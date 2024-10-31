package org.example.youngnam.global.exception.exceptions;

import org.example.youngnam.global.exception.ErrorCode;

public class EntityNotFoundException extends YoungnamException {
    public EntityNotFoundException() {
        super(ErrorCode.ENTITY_NOT_FOUND);
    }

    public EntityNotFoundException(final ErrorCode errorCode) {
        super(errorCode);
    }
}
