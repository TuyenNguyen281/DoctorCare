package com.example.prj321x_project3_tuyenndfx29367.restcontroller;

import com.example.prj321x_project3_tuyenndfx29367.dto.reponse.ResponseMassage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ResponseMassage> handleException(Exception exception) {
        ResponseMassage responseMassage = new ResponseMassage(
                HttpStatus.BAD_REQUEST.value(), exception.getMessage(),System.currentTimeMillis()
        );
        return new ResponseEntity<>(responseMassage,HttpStatus.BAD_REQUEST);
    }
}
