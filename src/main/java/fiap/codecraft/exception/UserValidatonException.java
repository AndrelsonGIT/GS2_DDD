package fiap.codecraft.exception;

public class UserValidatonException extends RuntimeException {

    public UserValidatonException() {
    }

    public UserValidatonException(String message) {
        super(message);
    }

    public UserValidatonException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserValidatonException(Throwable cause) {
        super(cause);
    }

    public UserValidatonException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
