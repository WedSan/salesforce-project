package wedsan.salesforceproject.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserCreationRequest(
        @NotBlank
        String name,
        @Email
        String email,
        @NotBlank
        String password,
        @NotBlank
        String position,
        @NotNull
        int telephoneNumber,
        @NotBlank
        String companyName,
        @NotBlank
        String companySector
) {
}
