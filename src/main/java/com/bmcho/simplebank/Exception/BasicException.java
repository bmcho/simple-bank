package com.bmcho.simplebank.Exception;

import lombok.Getter;

@Getter
public class BasicException extends RuntimeException {

    private final ErrorCode errorCode;
    private final String message;

    public BasicException(ErrorCode errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }
    public BasicException(ErrorCode errorCode) {
        this.errorCode = errorCode;
        this.message = errorCode.getMessage();
    }

    public String getMessage() {
        return String.format("%s. %s", errorCode.getMessage(), message);
    }

}
