package wedsan.salesforceproject.service.User;

import org.springframework.stereotype.Service;
import wedsan.salesforceproject.dto.request.UserCreationRequest;
import wedsan.salesforceproject.infra.exception.UserNotFoundException;
import wedsan.salesforceproject.infra.exception.UserValidationException;
import wedsan.salesforceproject.model.UserCompanyEntity;
import wedsan.salesforceproject.model.UserEntity;
import wedsan.salesforceproject.repository.UserEntityRepository;
import wedsan.salesforceproject.service.User.validation.UserValidator;
import wedsan.salesforceproject.service.UserCompanyService;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserCompanyService userCompanyService;

    private UserEntityRepository userRepository;

    private List<UserValidator> userValidatorsList;

    public UserService(UserCompanyService userCompanyService, UserEntityRepository userRepository,
                       List<UserValidator> userValidatorsList) {
        this.userCompanyService = userCompanyService;
        this.userRepository = userRepository;
        this.userValidatorsList = userValidatorsList;
    }

    public UserEntity createUser(UserCreationRequest userRequest) {

        userValidatorsList.forEach(v -> v.validate(userRequest));

        UserCompanyEntity userCompanyEntity = userCompanyService.createUserCompany(userRequest.companyName(),
                userRequest.companySector(), userRequest.minEmployees(), userRequest.maxEmployees());

        UserEntity userEntityToBeCreated = new UserEntity(userRequest.name(),
                userRequest.fullname(),
                userRequest.email(),
                userRequest.password(),
                userRequest.position(),
                userRequest.telephoneNumber(),
                userCompanyEntity);

        return userRepository.save(userEntityToBeCreated);
    }

    public UserEntity findByEmail(String email){
        Optional<UserEntity> optionalUserEntity =  userRepository.findByEmail(email);
        if(optionalUserEntity.isEmpty()){
            throw new UserNotFoundException("Usuário com este email: "+email+" não existe");
        }
        return optionalUserEntity.get();
    }
}
