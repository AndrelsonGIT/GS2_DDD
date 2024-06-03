package fiap.codecraft.controller;

import fiap.codecraft.DTO.request.LogInDTORequest;
import fiap.codecraft.DTO.response.AuthenticationResponse;
import fiap.codecraft.exception.exceptionHandler.error.ErrorResponse;
import fiap.codecraft.exception.exceptionHandler.error.ErrorType;
import fiap.codecraft.service.AuthenticationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("login")
public class LogInController {

    private AuthenticationService authentication;

    public LogInController(AuthenticationService authentication) {
        this.authentication = authentication;
    }

    @PostMapping
    public ResponseEntity<Object> logIn(@RequestBody LogInDTORequest request){
        Optional<String> optionalToken = authentication.authenticate(request.email(), request.password());

        if(optionalToken.isEmpty()){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ErrorResponse("Invalid Password", ErrorType.INVALID_FIELD));
        }

        return ResponseEntity.ok().body(new AuthenticationResponse(request.email(), optionalToken.get()));
    }
}
