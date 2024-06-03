package fiap.codecraft.service.validator;

import fiap.codecraft.DTO.request.UserCreateDTORequest;
import fiap.codecraft.exception.UserValidatonException;
import fiap.codecraft.model.UserEntity;
import fiap.codecraft.repository.UserRepository;

import java.util.Optional;

public class UserEmailValidator implements UserCreationValidator{

    private UserRepository userRepository;

    public UserEmailValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void validate(UserCreateDTORequest userToValidated) {
        Optional<UserEntity> optionalUserEntity = userRepository.findByEmail(userToValidated.email());

        if(optionalUserEntity.isEmpty()){
            throw new UserValidatonException("Email: " + userToValidated.email() + " already exists");
        }
    }
}
