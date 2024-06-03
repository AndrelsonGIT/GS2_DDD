package fiap.codecraft.controller;

import fiap.codecraft.DTO.request.UserCreateDTORequest;
import fiap.codecraft.DTO.response.UserCreateDTOResponse;
import fiap.codecraft.model.UserEntity;
import fiap.codecraft.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserCreateDTOResponse> createUser(@RequestBody UserCreateDTORequest user) {
        UserEntity userEntityCreated = userService.createUser(user);

        UserCreateDTOResponse response = new UserCreateDTOResponse(
                userEntityCreated.getId(),
                userEntityCreated.getFullName(),
                userEntityCreated.getEmail(),
                userEntityCreated.getPassword(),
                userEntityCreated.getAddress().getCep(),
                userEntityCreated.getAddress().getStreet(),
                userEntityCreated.getAddress().getNeighborhood(),
                userEntityCreated.getAddress().getCity(),
                userEntityCreated.getAddress().getState()
                );

        return ResponseEntity.ok().body(response);
    }



}
