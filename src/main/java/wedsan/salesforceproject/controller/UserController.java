package wedsan.salesforceproject.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wedsan.salesforceproject.dto.request.UserCreationRequest;
import wedsan.salesforceproject.dto.response.CountUsersResponse;
import wedsan.salesforceproject.model.UserEntity;
import wedsan.salesforceproject.service.User.UserService;

import java.util.List;

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

    @GetMapping("/count")
    public ResponseEntity getAllUsers(){
        long numberUsers = userService.countUsers();
        return ResponseEntity.ok(new CountUsersResponse(numberUsers));
    }

}



