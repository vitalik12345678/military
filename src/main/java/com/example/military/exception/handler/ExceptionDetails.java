package com.example.military.exception.handler;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
public class ExceptionDetails {

    private final String MESSAGE;
    private final HttpStatus HTTPSTATUS;
    private final int HTTP_CODE;

}
