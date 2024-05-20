package wedsan.salesforceproject.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wedsan.salesforceproject.dto.request.LogInRequest;
import wedsan.salesforceproject.dto.response.AuthenticationResponse;
import wedsan.salesforceproject.model.UserEntity;
import wedsan.salesforceproject.repository.UserEntityRepository;
import wedsan.salesforceproject.service.User.UserService;
import wedsan.salesforceproject.service.UserAuthenticationService;

@RestController
@RequestMapping("/login")
public class LogInController {

    private UserAuthenticationService userAuthenticationService;

    private UserService userService;

    public LogInController(UserAuthenticationService userAuthenticationService, UserService userService) {
        this.userAuthenticationService = userAuthenticationService;
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity logInController(@RequestBody @Valid LogInRequest userRequest){
        boolean isAuthenticated = false;

        isAuthenticated = userAuthenticationService.authenticate(userRequest.email(), userRequest.password());

        if(isAuthenticated){
            UserEntity user =  userService.findByEmail(userRequest.email());
            return ResponseEntity.ok(new AuthenticationResponse(user.getName(), user.getEmail(), "abcd98"));
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}
