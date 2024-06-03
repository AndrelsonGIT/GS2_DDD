package fiap.codecraft.exception.exceptionHandler.error;

public record ErrorResponse(
    String message,
    ErrorType errorType
) {

}
