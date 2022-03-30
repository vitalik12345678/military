package com.example.military.exception.handler;


import com.example.military.exception.BadRequestException;
import com.example.military.exception.ExistsException;
import com.example.military.exception.MethodNotSupportedException;
import com.example.military.exception.NotExistsException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(NotExistsException.class)
    public final ResponseEntity<Object> handleNotExistException(NotExistsException e) {
        return buildExceptionBody(e, HttpStatus.CONFLICT);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(BadRequestException.class)
    public final ResponseEntity<Object> handleBadRequestException(BadRequestException e) {
        return buildExceptionBody(e, HttpStatus.BAD_REQUEST);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(ExistsException.class)
    public final ResponseEntity<Object> handleExistsException(ExistsException e) {
        return buildExceptionBody(e, HttpStatus.CONFLICT);
    }

    private ResponseEntity<Object> buildExceptionBody(Exception exception, HttpStatus httpStatus) {
        ExceptionDetails exceptionDetails = ExceptionDetails.builder()
                .MESSAGE(exception.getMessage())
                .HTTPSTATUS(httpStatus)
                .HTTP_CODE(httpStatus.value())
                .build();
        return ResponseEntity
                .status(httpStatus)
                .body(exceptionDetails);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException exception,
                                                                  HttpHeaders headers, HttpStatus status,
                                                                  WebRequest request) {
        return buildExceptionBody(new BadRequestException(exception.getMessage()), status);
    }

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(
            HttpRequestMethodNotSupportedException exception, HttpHeaders headers,
            HttpStatus status, WebRequest request) {
        return buildExceptionBody(new MethodNotSupportedException(exception.getMessage()), status);
    }

    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(
            MissingServletRequestParameterException exception, HttpHeaders headers, HttpStatus status,
            WebRequest request) {
        return buildExceptionBody(new BadRequestException(exception.getMessage()), status);
    }
}
