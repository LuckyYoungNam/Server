package org.example.youngnam.global.exception;

public class UnauthorizedException extends YoungnamException {
  public UnauthorizedException() {
    super(ErrorCode.UNAUTHORIZED);
  }

  public UnauthorizedException(final ErrorCode errorCode) {
    super(errorCode);
  }
}
