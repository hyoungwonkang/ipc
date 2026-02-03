package com.example.common.exception;

import com.example.common.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// 'abstract'로 만들어서 직접 쓰지 말고 상속받아 쓰라고 명시하는 것이 좋습니다.

// 하지만 편의상 @RestControllerAdvice를 붙여서 공통으로 동작하게 할 수도 있습니다.
// @RestControllerAdvice
public abstract class GlobalExceptionHandler {

  // 1. 공통: 알 수 없는 서버 에러 (500)
  @ExceptionHandler(Exception.class)
  public ResponseEntity<ErrorResponse> handleException(Exception e) {
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
        .body(ErrorResponse.of(e.getMessage(), "INTERNAL_SERVER_ERROR"));
  }

  // 2. 공통: 입력값 검증 실패 (400)
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ErrorResponse> handleValidationException(MethodArgumentNotValidException e) {
    String errorMessage = e.getBindingResult().getFieldError().getDefaultMessage();
    return ResponseEntity.status(HttpStatus.BAD_REQUEST)
        .body(ErrorResponse.of(e.getMessage(), "INVALID_INPUT"));
  }
}