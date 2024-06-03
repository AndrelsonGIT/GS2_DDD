package fiap.codecraft.service.Token;

import fiap.codecraft.model.UserEntity;
import fiap.codecraft.model.UserTokenEntity;
import fiap.codecraft.repository.TokenRepository;
import org.springframework.stereotype.Service;

@Service
public class UserTokenSerivce {

    private TokenRepository tokenRepository;

    private TokenGenerator tokenGenerator;

    public UserTokenSerivce(TokenRepository tokenRepository, TokenGenerator tokenGenerator) {
        this.tokenRepository = tokenRepository;
        this.tokenGenerator = tokenGenerator;
    }

    public UserTokenEntity createToken(UserEntity user){
        String token = tokenGenerator.generateToken(user.getEmail());

        UserTokenEntity userToken = new UserTokenEntity(null, token, user);

        return tokenRepository.save(userToken);
    }
}
