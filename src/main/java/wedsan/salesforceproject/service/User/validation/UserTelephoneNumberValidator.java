package wedsan.salesforceproject.service.User.validation;

import jakarta.validation.ValidationException;
import org.springframework.stereotype.Component;
import wedsan.salesforceproject.dto.request.UserCreationRequest;
import wedsan.salesforceproject.repository.UserEntityRepository;

@Component
public class UserTelephoneNumberValidator implements UserValidator{

    private UserEntityRepository userEntityRepository;

    public UserTelephoneNumberValidator(UserEntityRepository userEntityRepository) {
        this.userEntityRepository = userEntityRepository;
    }

    @Override
    public void validate(UserCreationRequest creationRequest) {
        System.out.println(creationRequest.telephoneNumber());

        if(userEntityRepository.existsByTelephoneNumber(creationRequest.telephoneNumber())){
            throw new ValidationException("Telephone number already exists");
        }
    }
}
