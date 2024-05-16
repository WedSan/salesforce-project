package wedsan.salesforceproject.service.User.validation;

import org.springframework.stereotype.Component;
import wedsan.salesforceproject.dto.request.UserCreationRequest;
import wedsan.salesforceproject.infra.exception.UserValidationException;
import wedsan.salesforceproject.repository.UserEntityRepository;

@Component
public class UserEmailCreationValidator implements UserValidator {

    private UserEntityRepository userRepository;

    public UserEmailCreationValidator(UserEntityRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void validate(UserCreationRequest userCreationRequest) {
        if(userRepository.existsByEmail(userCreationRequest.email())){
            throw new UserValidationException("Email já registrado: "+userCreationRequest.email());
        }
    }

}
