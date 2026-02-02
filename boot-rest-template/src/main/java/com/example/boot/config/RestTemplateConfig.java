package com.example.boot.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {
    @Bean
    RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder
            .additionalInterceptors((request, body, execution)->{
                HttpHeaders headers = new HttpHeaders();
                headers.set("Content-Type", "application/json");
                request.getHeaders().addAll(headers);
                return execution.execute(request, body);
            })
            .build();
    }
}
