package wedsan.salesforceproject.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wedsan.salesforceproject.dto.request.UserCreationRequest;
import wedsan.salesforceproject.infra.exception.UserValidationException;
import wedsan.salesforceproject.model.UserEntity;
import wedsan.salesforceproject.service.User.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity createUser(@RequestBody @Valid UserCreationRequest userRequest){
        UserEntity userEntityCreated = userService.createUser(userRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(userEntityCreated);
    }


}
