package com.immigration.system.dto.exceptions;

import com.immigration.system.dto.responses.BusinessRuleErrorResponse;
import com.immigration.system.dto.responses.ResourceNotFoundErrorResponse;
import com.immigration.system.dto.responses.ValidationErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Central place that converts thrown exceptions into the project's
 * three dedicated error response shapes (Validation / ResourceNotFound / BusinessRule),
 * plus generic fallbacks so nothing leaks a raw stack trace to the client.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    // ─── 404 — Resource Not Found ────────────────────────────────────────────
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ResourceNotFoundErrorResponse> handleResourceNotFound(
            ResourceNotFoundException ex, HttpServletRequest request) {

        ResourceNotFoundErrorResponse body = new ResourceNotFoundErrorResponse(
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

    // ─── 422 — Business Rule Violation ───────────────────────────────────────
    @ExceptionHandler(BusinessRuleException.class)
    public ResponseEntity<BusinessRuleErrorResponse> handleBusinessRule(
            BusinessRuleException ex, HttpServletRequest request) {

        BusinessRuleErrorResponse body = new BusinessRuleErrorResponse(
                HttpStatus.UNPROCESSABLE_ENTITY.value(),
                ex.getMessage(),
                "Business Rule Violation",
                request.getRequestURI(),
                ex.getRuleViolated()
        );
        return new ResponseEntity<>(body, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    // ─── 400 — Manual Validation Failure ─────────────────────────────────────
    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ValidationErrorResponse> handleValidation(
            ValidationException ex, HttpServletRequest request) {

        ValidationErrorResponse body = new ValidationErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                ex.getMessage(),
                "Validation Failed",
                request.getRequestURI(),
                ex.getFieldName(),
                ex.getRejectedValue()
        );
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    // ─── 400 — Fallback for plain RuntimeException("...") per spec ──────────
    // (Task instructions say "throw a standard RuntimeException" in places;
    //  this ensures those still return a clean validation-style response
    //  instead of a 500.)
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ValidationErrorResponse> handleRuntimeException(
            RuntimeException ex, HttpServletRequest request) {

        ValidationErrorResponse body = new ValidationErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                ex.getMessage(),
                "Bad Request",
                request.getRequestURI(),
                null,
                null
        );
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    // ─── 500 — Catch-all ──────────────────────────────────────────────────────
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ValidationErrorResponse> handleGenericException(
            Exception ex, HttpServletRequest request) {

        ValidationErrorResponse body = new ValidationErrorResponse(
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
