package wedsan.salesforceproject.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record LogInRequest(
        @Email(message = "O campo email deve ser um endereço de email válido.")
        String email,
        @NotBlank(message = "O campo senha não pode estar vazio.")
        String password
) {
}
