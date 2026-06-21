package com.immigration.system.dto.responses;

import java.time.LocalDateTime;

public class BusinessRuleErrorResponse {
    private int status;
    private String message;
    private String error;
    private LocalDateTime timestamp;
    private String path;
    private String ruleViolated;       // Specific to business rules


    //  Constructors
    public BusinessRuleErrorResponse() {}

    public BusinessRuleErrorResponse(int status, String message, String error,
                                     String path, String ruleViolated) {
        this.status = status;
        this.message = message;
        this.error = error;
        this.path = path;
        this.ruleViolated = ruleViolated;
        this.timestamp = LocalDateTime.now();
    }

    //  Getters & Setters
    public int getStatus() { return status; }
    public void setStatus(int status) { this.status = status; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public String getError() { return error; }
    public void setError(String error) { this.error = error; }

    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }

    public String getPath() { return path; }
    public void setPath(String path) { this.path = path; }

    public String getRuleViolated() { return ruleViolated; }
    public void setRuleViolated(String ruleViolated) { this.ruleViolated = ruleViolated; }
}



