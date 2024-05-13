package wedsan.salesforceproject.service.User;

import org.springframework.stereotype.Service;
import wedsan.salesforceproject.dto.request.UserCreationRequest;
import wedsan.salesforceproject.exception.UserValidationException;
import wedsan.salesforceproject.model.UserEntity;
import wedsan.salesforceproject.repository.UserEntityRepository;
import wedsan.salesforceproject.service.User.validation.UserValidator;

import java.util.List;

@Service
public class UserService {

    private UserEntityRepository userRepository;

    private List<UserValidator> userValidatorsList;

    public UserService(UserEntityRepository userRepository, List<UserValidator> userValidatorsList) {
        this.userRepository = userRepository;
        this.userValidatorsList = userValidatorsList;
    }

    public UserEntity createUser(UserCreationRequest userRequest) {
        try{
            userValidatorsList.forEach(v -> v.validate(userRequest));
        }
        catch(UserValidationException exception) {
            throw new UserValidationException(exception.getMessage());
        }


        UserEntity userEntityToBeCreated = new UserEntity(userRequest.name(),
                userRequest.email(),
                userRequest.password(),
                userRequest.companyName(),
                userRequest.position(),
                userRequest.companySector(),
                userRequest.telephoneNumber());

        return userRepository.save(userEntityToBeCreated);
    }
}
