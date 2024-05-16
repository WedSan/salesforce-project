package wedsan.salesforceproject.service;

import org.springframework.stereotype.Service;
import wedsan.salesforceproject.model.UserCompanyEntity;
import wedsan.salesforceproject.repository.UserCompanyRepository;

import java.util.Optional;

@Service
public class UserCompanyService {

    private UserCompanyRepository userCompanyRepository;

    public UserCompanyService(UserCompanyRepository userCompanyRepository) {
        this.userCompanyRepository = userCompanyRepository;
    }

    public UserCompanyEntity createUserCompany(String companyName, String companySector, int minEmployees, int maxEmployees) {
         Optional<UserCompanyEntity> optionalUserCompanyEntity = userCompanyRepository.findByName(companyName);

         if(optionalUserCompanyEntity.isPresent()) {
             return optionalUserCompanyEntity.get();
         }

         UserCompanyEntity userCompanyEntity = new UserCompanyEntity(companyName, minEmployees, maxEmployees,
                 companySector);

         return userCompanyRepository.save(userCompanyEntity);
    }
}
