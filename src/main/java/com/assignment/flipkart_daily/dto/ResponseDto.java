package com.assignment.flipkart_daily.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ResponseDto {
    private Object data;
    private HttpStatus status;
    private String errorMessage;
}
