package com.immigration.system.dto.responses;

import java.time.LocalDateTime;

public class ResourceNotFoundErrorResponse {

        private int status;
        private String message;
        private String error;
        private LocalDateTime timestamp;
        private String path;
        private String resourceName;
        private String fieldName;
        private Object fieldValue;

    //  Constructors
    public ResourceNotFoundErrorResponse() {}

    public ResourceNotFoundErrorResponse(int status, String message, String error,
                                         String path, String resourceName,
                                         String fieldName, Object fieldValue) {
        this.status = status;
        this.message = message;
        this.error = error;
        this.path = path;
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
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

    public String getResourceName() { return resourceName; }
    public void setResourceName(String resourceName) { this.resourceName = resourceName; }

    public String getFieldName() { return fieldName; }
    public void setFieldName(String fieldName) { this.fieldName = fieldName; }

    public Object getFieldValue() { return fieldValue; }
    public void setFieldValue(Object fieldValue) { this.fieldValue = fieldValue; }
}

