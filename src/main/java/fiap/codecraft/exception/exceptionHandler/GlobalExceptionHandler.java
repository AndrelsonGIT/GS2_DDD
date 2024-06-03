package fiap.codecraft.exception.exceptionHandler;

import fiap.codecraft.exception.APIRequestException;
import fiap.codecraft.exception.AddressNotFoundException;
import fiap.codecraft.exception.UserNotFoundException;
import fiap.codecraft.exception.UserValidatonException;
import fiap.codecraft.exception.exceptionHandler.error.ErrorResponse;
import fiap.codecraft.exception.exceptionHandler.error.ErrorType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.io.IOException;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> handleIllegalArgumentException(IllegalArgumentException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(ex.getMessage(),
                ErrorType.INVALID_FIELD));
    }

    @ExceptionHandler(APIRequestException.class)
    public ResponseEntity<ErrorResponse> handleException(APIRequestException ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ErrorResponse(ex.getMessage(), ErrorType.INTERNAL_ERROR));
    }

    @ExceptionHandler(UserValidatonException.class)
    public ResponseEntity handleException(UserValidatonException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponse(ex.getMessage(), ErrorType.INVALID_FIELD));
    }

    @ExceptionHandler(AddressNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleException(AddressNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(ex.getMessage(),
                ErrorType.INVALID_FIELD));
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleException(UserNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(ex.getMessage(),
                ErrorType.INVALID_FIELD));
    }

//    @ExceptionHandler(RuntimeException.class)
//    public ResponseEntity<ErrorResponse> handleException(RuntimeException ex) {
//        System.out.println(ex.getMessage());
//        ex.getStackTrace();
//        System.out.println(ex.getLocalizedMessage());
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                .body(new ErrorResponse("Erro interno do servidor ao processar a requisição",
//                        ErrorType.INTERNAL_ERROR));
//    }
}
