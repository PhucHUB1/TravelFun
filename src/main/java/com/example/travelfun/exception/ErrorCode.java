package com.example.travelfun.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {
    UNCATEGORIZED(9999,"Uncategorized error"),
    INVALID_CODE(1001,"Invalid message key"),
    USER_NOT_FOUND(1002,"User Not Found"),
    USER_NOT_EXISTED(1003,"User Not Existed"),
    INVALID_USERNAME(1004,"Username must be at least 3 characters"),
    INVALID_PASSWORD(1005,"Password must be at least 8 characters"),
    UNAUTHENTICATED(2000,"Unauthenticated error"),



    ;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private final int code;
    private final String message;


}
