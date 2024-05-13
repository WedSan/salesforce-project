package wedsan.salesforceproject.service.User.validation;

import wedsan.salesforceproject.dto.request.UserCreationRequest;

public interface UserValidator {
    void validate(UserCreationRequest creationRequest);
}
