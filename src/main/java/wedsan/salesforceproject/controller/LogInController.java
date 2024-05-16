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
import wedsan.salesforceproject.infra.exception.UserNotFoundException;
import wedsan.salesforceproject.model.UserEntity;
import wedsan.salesforceproject.repository.UserEntityRepository;
import wedsan.salesforceproject.service.UserAuthenticationService;

@RestController
@RequestMapping("/login")
public class LogInController {

    private UserAuthenticationService userService;

    private UserEntityRepository userRepository;

    public LogInController(UserAuthenticationService userService, UserEntityRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @PostMapping
    public ResponseEntity logInController(@RequestBody @Valid LogInRequest userRequest){
        boolean isAuthenticated = false;
        try{
            isAuthenticated = userService.authenticate(userRequest.email(), userRequest.password());
        }
        catch(UserNotFoundException e){
            return ResponseEntity.notFound().build();
        }

        if(isAuthenticated){
            UserEntity user = userRepository.findByEmail(userRequest.email()).get();
            return ResponseEntity.ok(new AuthenticationResponse(user.getName(), user.getEmail()));
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();

    }
}
