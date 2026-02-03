package com.example.common.exception;

import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException {
  // 모든 예외가 공통으로 가질 에러 코드
  private final String errorCode;

  public BusinessException(String message, String errorCode) {
    super(message);
    this.errorCode = errorCode;
  }
}