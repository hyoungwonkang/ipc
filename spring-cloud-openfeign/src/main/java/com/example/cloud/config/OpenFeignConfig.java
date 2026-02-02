package com.example.cloud.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Logger;
import feign.RequestInterceptor;

@Configuration
@EnableFeignClients(basePackages = {"com.example.cloud.client"}) // @FeignClient 허용
public class OpenFeignConfig {
    
    @Bean
    Logger.Level feignLogLevel() {
        return Logger.Level.FULL;
    }

    @Bean
    RequestInterceptor requestInterceptor() {
        return (restTemplate) -> {
            restTemplate.header("Content-Type", "application/json");
        };
    }
}
