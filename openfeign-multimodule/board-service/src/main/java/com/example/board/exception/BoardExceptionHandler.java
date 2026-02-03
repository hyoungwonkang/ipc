package com.example.board.exception;

import com.example.common.dto.ErrorResponse;
import com.example.common.exception.GlobalExceptionHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class BoardExceptionHandler extends GlobalExceptionHandler {

  // Board 서비스만의 예외: FeignClient 통신 중 사용자 없음
  @ExceptionHandler(UserNotFoundException.class)
  public ResponseEntity<ErrorResponse> handleUserNotFound(UserNotFoundException e) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND)
      .body(ErrorResponse.of(e.getMessage(), e.getErrorCode()));
  }
}