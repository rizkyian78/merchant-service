package com.ipg.merchantservice.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ErrorResponse extends Throwable {

    private String message;
    private  int statusCode;

    public ErrorResponse(int statusCode,String message) {
        super();
        this.statusCode = statusCode;
        this.message = message;
    }
}
