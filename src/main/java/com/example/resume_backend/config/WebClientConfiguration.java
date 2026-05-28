package com.example.resume_backend.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

import static com.example.resume_backend.log.LoggingFilter.logRequest;
import static com.example.resume_backend.log.LoggingFilter.logResponse;


@Configuration
public class WebClientConfiguration {
    @Value("${api.resume.api-key-name}")
    private String API_RESUME_KEY_NAME;
    @Value("${api.resume.api-key}")
    private String API_RESUME_KEY;
    @Value("${api.resume.api-base-url}")
    private String API_RESUME_BASE_URL;

    @Bean
    public WebClient webClient() {
        return WebClient
                .builder()
                .baseUrl(API_RESUME_BASE_URL)
                .defaultHeader(API_RESUME_KEY_NAME, API_RESUME_KEY)
                .filter(logRequest())
                .filter(logResponse())
                .build();
    }
}
