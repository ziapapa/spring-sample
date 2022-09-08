package com.ziapapa.spring.sample.exception;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.ziapapa.spring.sample.dto.common.CommonRes;
import com.ziapapa.spring.sample.dto.common.ErrorRes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler({MethodArgumentNotValidException.class, InvalidFormatException.class})
    protected ResponseEntity<CommonRes> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.error("handleMethodArgumentNotValidException", e);
        final CommonRes commonRes = new CommonRes(null, ErrorRes.of(ErrorCode.INVALID_INPUT_VALUE, e.getBindingResult().getFieldError().getField()));
        return new ResponseEntity<>(commonRes, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BusinessException.class)
    protected ResponseEntity<CommonRes> handleBusinessException(final BusinessException e) {
        log.error("handleEntityNotFoundException", e);
        final ErrorCode errorCode = e.getErrorCode();
        final String msg = e.getMsg();
        final CommonRes commonRes = new CommonRes(null, ErrorRes.of(errorCode, msg));
        return new ResponseEntity<>(commonRes, HttpStatus.valueOf(errorCode.getStatus()));
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<CommonRes> handleException(Exception e) {
        log.error("handleEntityNotFoundException", e);
        final CommonRes commonRes = new CommonRes(null, new ErrorRes());
        return new ResponseEntity<>(commonRes, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

