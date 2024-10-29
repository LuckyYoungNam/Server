package org.example.youngnam.global.exception;

public class BadRequestException extends YoungnamException {
  public BadRequestException() {
    super(ErrorCode.BAD_REQUEST);
  }

  public BadRequestException(final ErrorCode errorCode) {
    super(errorCode);
  }
}