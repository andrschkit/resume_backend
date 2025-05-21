package com.example.resume_backend.log;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class LoggingFilter extends OncePerRequestFilter {

    private static final Logger log
            = LoggerFactory.getLogger(LoggingFilter.class);

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain) throws ServletException, IOException {


        long startTime = System.currentTimeMillis();

        // Продолжить обработку запроса
        filterChain.doFilter(request, response);

        long duration = System.currentTimeMillis() - startTime;

        boolean isRestRequest = request.getRequestURI().startsWith("/api");

        if (isRestRequest || request.getMethod().matches("POST|DELETE")) {
            // Создание записи лога

            String logMessage = String.format("request IP: %s, user: %s, request method: %s, request URI: %s, request params: %s, response status: %d, request processing time: %d ms",
                    getClientIP2(request),
                    isRestRequest ? "" : request.getUserPrincipal().getName(),
                    request.getMethod(),
                    request.getRequestURI(),
                    getRequestParams(request),
                    response.getStatus(),
                    duration);

            // Запись лога
            logger.info(logMessage);
        }
    }

    public static String getRequestParams(HttpServletRequest request) {

        Map<String, String[]> requestParamsMap = request.getParameterMap();

        String requestParams = requestParamsMap.keySet().stream()
                .filter(key -> !key.equals("_csrf"))
                .map(key -> key + "=" + Arrays.toString(requestParamsMap.get(key)))
                .collect(Collectors.joining(", ", "{", "}"));

        return requestParams;
    }

    public static ExchangeFilterFunction logRequest() {
        return ExchangeFilterFunction.ofRequestProcessor(clientRequest -> {
            log.info("RestApiRequest: {} {} {}",
                    clientRequest.method(),
                    clientRequest.url().getPath(),
                    clientRequest.url().getQuery()
            );
            return Mono.just(clientRequest);
        });
    }

    public static ExchangeFilterFunction logResponse() {
        return ExchangeFilterFunction.ofResponseProcessor(clientResponse -> {
            log.info("RestApiResponse status: {}", clientResponse.statusCode());
            return Mono.just(clientResponse);
        });
    }



    public static String getClientIP1(HttpServletRequest request) {
        final String xfHeader = request.getHeader("X-Forwarded-For");
        if (xfHeader != null) {
            return xfHeader.split(",")[0];
        }
        return request.getRemoteAddr();
    }

    public static String getClientIP2(HttpServletRequest request) {
        String xfHeader = request.getHeader("X-Forwarded-For");
        if (xfHeader == null || xfHeader.isEmpty() || !xfHeader.contains(request.getRemoteAddr())) {
            return request.getRemoteAddr();
        }
        return xfHeader.split(",")[0];
    }

}
