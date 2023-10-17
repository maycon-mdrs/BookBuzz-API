package com.web2.bookbuzz.dto.responses;

import org.springframework.http.HttpStatus;

public class ErrorResponseDTO {
    HttpStatus httpStatus;
    String message;

    public ErrorResponseDTO(HttpStatus httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}