package com.bmcho.simplebank.Exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    EXCEPTION_OCCURRED(HttpStatus.INTERNAL_SERVER_ERROR,"An exception occurred"),
    USER_REGISTRATION_FAILED(HttpStatus.BAD_REQUEST, "User registration failed")
    ;

    private final HttpStatus status;
    private final String message;
}
