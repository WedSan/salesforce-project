package wedsan.salesforceproject.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record  FeedbackRequest(
        @NotBlank
        String feedbackType,
        @NotBlank
        String feedbackText,
        @NotNull
        int feedbackNote,
        String feedbackUserEmail
) {

}
