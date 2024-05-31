package fiap.codecraft.exceptionHandler.error;

import org.aspectj.weaver.patterns.PerThisOrTargetPointcutVisitor;

public record ErrorResponse(
    String message,
    ErrorType errorType
) {

}
