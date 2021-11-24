package com.mindali.zeev.question.advice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mindali.zeev.question.exceptions.JsonException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class RestAdvice {
    //intercept json structure error in rest requestest
    @ExceptionHandler(value = {JsonException.class})
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ErrorDetails handleException(Exception err){
        return new ErrorDetails("JSON ERROR", err.getMessage());
    }

}
