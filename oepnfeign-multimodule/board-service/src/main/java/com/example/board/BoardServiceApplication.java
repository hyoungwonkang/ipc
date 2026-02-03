package com.example.board;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients  // Feign Client를 스캔하고 사용할 수 있도록 설정
public class BoardServiceApplication {
  public static void main(String[] args) {
    SpringApplication.run(BoardServiceApplication.class, args);
  }
}