package wedsan.salesforceproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wedsan.salesforceproject.model.FeedbackEntity;

@Repository
public interface FeedBackRepository extends JpaRepository<FeedbackEntity, Long> {
}
