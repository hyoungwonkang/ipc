package com.example.common.dto;

import java.time.LocalDateTime;

// 모든 서비스가 이 포맷으로 에러를 반환하기로 약속합니다.
public record ErrorResponse(
  String message, 
  String code, 
  LocalDateTime timestamp
) {
  public static ErrorResponse of(String message, String code) {
    return new ErrorResponse(message, code, LocalDateTime.now());
  }
}