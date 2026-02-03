package com.example.board.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenFeignConfig {

  // Feign 클라이언트의 로그 레벨을 설정합니다.
  @Bean
  Logger.Level feignLoggerLevel() {
    return Logger.Level.FULL;
  }
}