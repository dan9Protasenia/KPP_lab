package com.example.demo.advice;


import com.example.demo.responses.ExceptionResponce;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.rmi.ServerException;


@RestControllerAdvice
public class DefaultAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ServerException.class)
    public ResponseEntity<ExceptionResponce> handleException(ServerException e) {
        logger.error("ERROR CODE 400", e);
        return new ResponseEntity<>(new ExceptionResponce(e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponce> handleException(Exception e) {
        logger.error("ERROR CODE 500", e);
        return new ResponseEntity<>(new ExceptionResponce(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ExceptionResponce> handleException(MethodArgumentTypeMismatchException e){
        logger.error("FAILED FORMAT PARAMETER",e);
        return new ResponseEntity<>(new ExceptionResponce(e.getMessage()),HttpStatus.BAD_REQUEST);
    }
}
