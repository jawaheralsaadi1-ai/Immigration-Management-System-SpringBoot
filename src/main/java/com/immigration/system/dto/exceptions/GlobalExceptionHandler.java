package com.immigration.system.dto.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Central place that converts thrown exceptions into the project
 *
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    // 404
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ResourceNotFoundException> handleResourceNotFound(
            ResourceNotFoundException ex, HttpServletRequest request) {

        ResourceNotFoundException body = new ResourceNotFoundException(
                HttpStatus.NOT_FOUND.value(),
                ex.getMessage(),
                "Not Found",
                request.getRequestURI(),
                ex.getResourceName(),
                ex.getFieldName(),
                ex.getFieldValue()
        );
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    // 422
    @ExceptionHandler(BusinessRuleException.class)
    public ResponseEntity<BusinessRuleException> handleBusinessRule(
            BusinessRuleException ex, HttpServletRequest request) {

        BusinessRuleException body = new BusinessRuleException(
                HttpStatus.UNPROCESSABLE_ENTITY.value(),
                ex.getMessage(),
                "Business Rule Violation",
                request.getRequestURI(),
                ex.getRuleViolated()
        );
        return new ResponseEntity<>(body, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    // 400
    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ValidationException> handleValidation(
            ValidationException ex, HttpServletRequest request) {

        ValidationException body = new ValidationException(
                HttpStatus.BAD_REQUEST.value(),
                ex.getMessage(),
                "Validation Failed",
                request.getRequestURI(),
                ex.getFieldName(),
                ex.getRejectedValue()
        );
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    //  400
    //
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ValidationException> handleRuntimeException(
            RuntimeException ex, HttpServletRequest request) {

        ValidationException body = new ValidationException(
                HttpStatus.BAD_REQUEST.value(),
                ex.getMessage(),
                "Bad Request",
                request.getRequestURI(),
                null,
                null
        );
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    // 500
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ValidationException> handleGenericException(
            Exception ex, HttpServletRequest request) {

        ValidationException body = new ValidationException(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "An unexpected error occurred: " + ex.getMessage(),
                "Internal Server Error",
                request.getRequestURI(),
                null,
                null
        );
        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
