package com.example.board.client;

import com.example.common.dto.UserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// 인터페이스 + 어노테이션 방식의 선언적 HTTP 클라이언트 방식

// name: 호출하려는 Eureka Service ID (user-service의 spring.application.name)
@FeignClient(name = "user-service") 
public interface UserClient {

  // 호출하려는 API 명세와 정확히 일치시켜야 함
  @GetMapping("/api/users/{userId}")
  UserResponse getUser(@PathVariable("userId") Long userId);
}