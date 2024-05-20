package wedsan.salesforceproject.service;

import org.springframework.stereotype.Service;
import wedsan.salesforceproject.infra.exception.UserNotFoundException;
import wedsan.salesforceproject.model.UserEntity;
import wedsan.salesforceproject.repository.UserEntityRepository;

import java.util.Optional;

@Service
public class UserAuthenticationService {

    private UserEntityRepository userRepository;

    public UserAuthenticationService(UserEntityRepository userRepository) {
        this.userRepository = userRepository;

    }

    public boolean authenticate(String email, String password) {
        Optional<UserEntity> optionalUserEntity = userRepository.findByEmail(email);

        if(optionalUserEntity.isEmpty()) {
            throw new UserNotFoundException("Usuário com o email: "+email+" não foi encontrado");
        }

        return optionalUserEntity.get().getPassword().equals(password);
    }
}
