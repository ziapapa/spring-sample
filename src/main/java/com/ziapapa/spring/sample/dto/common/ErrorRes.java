package com.ziapapa.spring.sample.dto.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ziapapa.spring.sample.exception.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class ErrorRes {

    private String message;

    @JsonIgnore
    private int status;

    private String code;

    private ErrorRes(final ErrorCode code) {
        this.message = code.getMessage();
        this.status = code.getStatus();
        this.code = code.getCode();
    }

    private ErrorRes(final ErrorCode code, final String msg ) {
        this.message = code.getMessage().replace("{{msg}}", msg);
        this.status = code.getStatus();
        this.code = code.getCode();
    }

    public static ErrorRes of(final ErrorCode code) {
        return new ErrorRes(code);
    }

    public static ErrorRes of(final ErrorCode code, final String msg) {
        return new ErrorRes(code, msg);
    }

}
