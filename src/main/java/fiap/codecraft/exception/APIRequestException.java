package fiap.codecraft.exception;

public class APIRequestException extends RuntimeException{
    public APIRequestException() {
    }

    public APIRequestException(String message) {
        super(message);
    }

    public APIRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    public APIRequestException(Throwable cause) {
        super(cause);
    }

    public APIRequestException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
