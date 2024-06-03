package fiap.codecraft.exception.exceptionHandler.error;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ErrorType {
    INVALID_FIELD("INVALID_FIELD"),

    INTERNAL_ERROR("INTERNAL_ERROR");

    private final String errorType;

    ErrorType(String errorType) {
        this.errorType = errorType;
    }

    @JsonValue
    public String getErrorType() {
        return errorType;
    }
}
