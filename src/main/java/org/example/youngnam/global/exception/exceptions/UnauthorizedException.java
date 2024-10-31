package org.example.youngnam.global.exception.exceptions;

import org.example.youngnam.global.exception.ErrorCode;

public class UnauthorizedException extends YoungnamException {
  public UnauthorizedException() {
    super(ErrorCode.UNAUTHORIZED);
  }

  public UnauthorizedException(final ErrorCode errorCode) {
    super(errorCode);
  }
}
