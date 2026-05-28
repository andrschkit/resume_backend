package com.example.resume_backend.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Value("${api.resume.api-key-name}")
    private String apiKeyName;
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components()
                        .addSecuritySchemes("apiKeyAuth", // Имя схемы (используется в аннотациях)
                                new SecurityScheme()
                                        .type(SecurityScheme.Type.APIKEY)
                                        .in(SecurityScheme.In.HEADER) // Где передается ключ: HEADER, QUERY, COOKIE
                                        .name(apiKeyName) // Имя заголовка/параметра
                        )
                )
                .info(new Info()
                        .title("API резюме разработчика")
                        .version("1.0.0")
                );
    }
}
