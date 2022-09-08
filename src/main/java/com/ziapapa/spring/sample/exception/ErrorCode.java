package com.ziapapa.spring.sample.exception;

public enum ErrorCode {
    INVALID_INPUT_VALUE(400, "INVALID_INPUT_VALUE", "INVALID_INPUT_VALUE [{{msg}}]"),
    BAD_REQUEST_BODY(400, "BAD_REQUEST_BODY","BAD_REQUEST_BODY"),
    ALREADY_EXIST_STUDENT(400, "ALREADY_EXIST_STUDENT", "이미 존재하는 학생입니다. [{{msg}}]"),
    ALREADY_EXIST_SUBJECT(400, "ALREADY_EXIST_SUBJECT","이미 존재하는 과목입니다. [{{msg}}]"),
    STUDENT_NOT_FOUND(404, "STUDENT_NOT_FOUND", "학생을 찾을 수 없습니다. [{{msg}}]"),
    SUBJECT_NOT_FOUND(404, "SUBJECT_NOT_FOUND", "과목을 찾을 수 없습니다. [{{msg}}]")

    ;

    private final String message;
    private int status;
    private final String code;

    ErrorCode(final int status,  final String code,  final String message) {
        this.status = status;
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return this.message;
    }

    public String getCode() {
        return code;
    }

    public int getStatus() {
        return status;
    }
}