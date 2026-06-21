package com.immigration.system.dto.exceptions;


import org.springframework.http.HttpStatus;

/**
 * (HTTP 404).
 */
public class ResourceNotFoundException extends RuntimeException {

    private final String resourceName;
    private final String fieldName;
    private final Object fieldValue;

    public ResourceNotFoundException(int value, String message, String notFound, String requestURI, String resourceName, String fieldName, Object fieldValue) {
        super(resourceName + " not found with " + fieldName + " = '" + fieldValue + "'");
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public ResourceNotFoundException(String resourceName, Long id) {
        this(HttpStatus.NOT_FOUND.value(), ex.getMessage(), "Not Found", request.getRequestURI(), resourceName, "id", id);
    }

    public String getResourceName() {
        return resourceName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public Object getFieldValue() {
        return fieldValue;
    }
}
