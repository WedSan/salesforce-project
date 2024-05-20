package wedsan.salesforceproject.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.Length;

import java.math.BigInteger;

public record UserCreationRequest(
        @NotBlank
        String name,
        @NotBlank
        String fullname,
        @Email
        String email,
        @NotBlank
        String password,
        @NotBlank
        String position,
        @NotNull
        String telephoneNumber,
        @NotBlank
        String companyName,
        @NotBlank
        String companySector,
        @NotNull
        int minEmployees,
        @NotNull
        int maxEmployees
) {
}
