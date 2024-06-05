package fiap.codecraft.service.Token;

import fiap.codecraft.model.UserEntity;
import fiap.codecraft.model.UserTokenEntity;
import fiap.codecraft.repository.TokenRepository;
import fiap.codecraft.service.Observer;
import org.springframework.stereotype.Service;

@Service
public class UserTokenSerivce implements Observer {

    private TokenRepository tokenRepository;

    private TokenGenerator tokenGenerator;

    public UserTokenSerivce(TokenRepository tokenRepository, TokenGenerator tokenGenerator) {
        this.tokenRepository = tokenRepository;
        this.tokenGenerator = tokenGenerator;
    }

    @Override
    public void update(UserEntity user) {
        createToken(user);
    }

    public UserTokenEntity createToken(UserEntity user){
        String token = tokenGenerator.generateToken(user.getEmail());

        UserTokenEntity userToken = new UserTokenEntity(null, token, user);

        return tokenRepository.save(userToken);
    }
}
