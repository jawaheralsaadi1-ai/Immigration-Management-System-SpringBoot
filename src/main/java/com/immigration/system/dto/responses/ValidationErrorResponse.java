package com.immigration.system.dto.responses;

import java.time.LocalDateTime;

public class ValidationErrorResponse {
    private int status;
    private String message;
    private String error;
    private LocalDateTime timestamp;
    private String path;
    private String fieldName;           // Specific to validation
    private Object rejectedValue;  // Specific to validation




    public ValidationErrorResponse() {}
//Constructor
    public ValidationErrorResponse(int status, String message, String error,
                                   String path, String fieldName, Object rejectedValue) {
        this.status = status;
        this.message = message;
        this.error = error;
        this.path = path;
        this.fieldName = fieldName;
        this.rejectedValue = rejectedValue;
        this.timestamp = LocalDateTime.now();
    }

    // Getters & Setters
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

    public String getFieldName() { return fieldName; }
    public void setFieldName(String fieldName) { this.fieldName = fieldName; }

    public Object getRejectedValue() { return rejectedValue; }
    public void setRejectedValue(Object rejectedValue) { this.rejectedValue = rejectedValue; }
}
