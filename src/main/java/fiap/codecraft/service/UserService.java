package fiap.codecraft.service;

import fiap.codecraft.DTO.request.UserCreateDTORequest;
import fiap.codecraft.exception.UserNotFoundException;
import fiap.codecraft.model.UserAddressEntity;
import fiap.codecraft.model.UserEntity;
import fiap.codecraft.repository.UserRepository;
import fiap.codecraft.service.Token.UserTokenSerivce;
import fiap.codecraft.service.address.AddressService;
import fiap.codecraft.service.validator.UserCreationValidator;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements Subject{

    private UserRepository userRepository;

    private AddressService addressService;

    private List<UserCreationValidator> validators;

    private List<Observer> observers;

    public UserService(UserRepository userRepository, AddressService addressService, List<UserCreationValidator> validators) {
        this.userRepository = userRepository;
        this.addressService = addressService;
        this.validators = validators;
    }

    public UserEntity createUser(UserCreateDTORequest userRequest) {
        validators.forEach((v) -> v.validate(userRequest));

        UserAddressEntity address = addressService.getAddress(userRequest.cep(), userRequest.houseNumber());

        UserEntity userEntity = new UserEntity(null,
                userRequest.fullName(),
                userRequest.email(),
                userRequest.password(),
                address);

        userEntity = userRepository.save(userEntity);

        return userEntity;
    }

    public UserEntity findByEmail(String email){
        Optional<UserEntity> optionalUserEntity = userRepository.findByEmail(email);

        if(optionalUserEntity.isEmpty()){
            throw new UserNotFoundException("User does not exist");
        }

        return optionalUserEntity.get();
    }

    public UserEntity editPassword(String newPassword, String oldEmail) {
        UserEntity userEntity = findByEmail(oldEmail);
        userEntity.setPassword(newPassword);
        return userRepository.save(userEntity);
    }

    @Override
    public void notifyObservers(UserEntity user) {
        observers.forEach((e) -> e.update(user));
    }
}
