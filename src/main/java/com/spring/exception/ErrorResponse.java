package com.spring.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
public class ErrorResponse {

    private Boolean success;

    private String message;

    private LocalDateTime dateTime;

    private List<String> details;

    public ErrorResponse(Boolean success, String message, LocalDateTime dateTime, List<String> details) {
        this.success = Boolean.FALSE;
        this.message = message;
        this.dateTime = LocalDateTime.now();
        this.details = details;
    }


    public ErrorResponse(String message, List<String> details) {
        this.message = message;
        this.details = details;
    }
}
