package fiap.codecraft.service.validator;

import fiap.codecraft.DTO.request.UserCreateDTORequest;
import fiap.codecraft.model.UserEntity;

public interface UserCreationValidator {
    void validate(UserCreateDTORequest userToValidated);
}
