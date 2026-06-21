package com.immigration.system.dto.responses;

/**
(HTTP 422).
 */
public class BusinessRuleException extends RuntimeException {

    private final String ruleViolated;

    public BusinessRuleException(String message, String ruleViolated) {
        super(message);
        this.ruleViolated = ruleViolated;
    }

    public BusinessRuleException(String message) {
        super(message);
        this.ruleViolated = "GENERAL_BUSINESS_RULE";
    }

    public String getRuleViolated() {
        return ruleViolated;
    }
}