package com.bridgelabz.employeepayroll.Exception.exceptionhandler;

import com.bridgelabz.employeepayroll.Exception.EmployeeNotFoundException;
import com.bridgelabz.employeepayroll.Util.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;


@ControllerAdvice
public class EmployeeExceptionHandler {
    private static final String DEFAULT_ERROR_VIEW = "";

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<Response> handleHiringException(EmployeeNotFoundException he){
        Response response=new Response();
        response.setErrorCode(400);
        response.setMessage(he.getMessage());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Response>
    defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        Response response=new Response();
        response.setErrorCode(400);
        response.setMessage(e.getMessage());
        return new ResponseEntity<Response>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
