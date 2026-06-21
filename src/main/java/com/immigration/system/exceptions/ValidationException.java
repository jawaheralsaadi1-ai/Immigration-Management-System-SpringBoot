package com.immigration.system.exceptions;

/**
 * Thrown when manual input validation fails (null/empty required fields,
 * out-of-range values, invalid status strings). Caught by GlobalExceptionHandler
 * and converted into a ValidationErrorResponse (HTTP 400).
 */
public class ValidationException extends RuntimeException {

    private final String fieldName;
    private final Object rejectedValue;

    public ValidationException(String message, String fieldName, Object rejectedValue) {
        super(message);
        this.fieldName = fieldName;
        this.rejectedValue = rejectedValue;
    }

    public ValidationException(String message) {
        super(message);
        this.fieldName = null;
        this.rejectedValue = null;
    }

    public String getFieldName() {
        return fieldName;
    }

    public Object getRejectedValue() {
        return rejectedValue;
    }
}