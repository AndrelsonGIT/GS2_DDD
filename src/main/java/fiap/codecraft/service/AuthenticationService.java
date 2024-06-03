package fiap.codecraft.service;

import fiap.codecraft.repository.TokenRepository;
import fiap.codecraft.model.UserEntity;
import fiap.codecraft.model.UserTokenEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationService {

    private UserService userService;

    private TokenRepository tokenRepository;

    public AuthenticationService(UserService userService, TokenRepository tokenRepository) {
        this.userService = userService;
        this.tokenRepository = tokenRepository;
    }


    public Optional<String> authenticate(String email, String password) {
        UserEntity userEntity = userService.findByEmail(email);

        if(userEntity.getPassword().equals(password)) {
            UserTokenEntity userTokenEntity = tokenRepository.findByUserId(userEntity.getId());
            return Optional.of(userTokenEntity.getToken());
        }

        return Optional.empty();

    }
}
