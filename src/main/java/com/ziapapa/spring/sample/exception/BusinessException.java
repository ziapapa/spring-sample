package com.ziapapa.spring.sample.exception;

public class BusinessException extends RuntimeException {

    private ErrorCode errorCode;

    private String msg;

    public BusinessException(String message, ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public BusinessException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public BusinessException(ErrorCode errorCode, String msg) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
        this.msg = msg;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public String getMsg() {
        return msg;
    }

}
