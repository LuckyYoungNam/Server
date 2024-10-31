package org.example.youngnam.global.exception.exceptions;

import org.example.youngnam.global.exception.ErrorCode;

public class BadRequestException extends YoungnamException {
  public BadRequestException() {
    super(ErrorCode.BAD_REQUEST);
  }

  public BadRequestException(final ErrorCode errorCode) {
    super(errorCode);
  }
}