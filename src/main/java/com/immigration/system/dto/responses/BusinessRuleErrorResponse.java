package com.immigration.system.dto.responses;

import java.time.LocalDateTime;

// src/main/java/com/immigration/dtos/BusinessRuleErrorResponse.java
public class BusinessRuleErrorResponse {
    private int status;
    private String message;
    private String error;
    private LocalDateTime timestamp;
    private String path;
    private String ruleViolated;       // Specific to business rules

    // getters/setters
}
