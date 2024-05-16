package wedsan.salesforceproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wedsan.salesforceproject.model.UserCompanyEntity;

import java.util.Optional;

@Repository
public interface UserCompanyRepository extends JpaRepository<UserCompanyEntity, Long> {
    Optional<UserCompanyEntity> findByName(String name);
}
