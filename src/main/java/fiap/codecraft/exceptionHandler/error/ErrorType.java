package fiap.codecraft.exceptionHandler.error;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ErrorType {
    INVALID_FIELD("INVALID_FIELD");

    private final String errorType;

    ErrorType(String errorType) {
        this.errorType = errorType;
    }

    @JsonValue
    public String getErrorType() {
        return errorType;
    }
}
