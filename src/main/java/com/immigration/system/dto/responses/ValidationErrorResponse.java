package com.immigration.system.dto.responses;

import java.time.LocalDateTime;

// src/main/java/com/immigration/dtos/ValidationErrorResponse.java
public class ValidationErrorResponse {
    private int status;
    private String message;
    private String error;
    private LocalDateTime timestamp;
    private String path;
    private String fieldName;           // Specific to validation
    private Object rejectedValue;       // Specific to validation

    // getters/setters
}