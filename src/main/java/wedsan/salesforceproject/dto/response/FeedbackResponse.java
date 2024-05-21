package wedsan.salesforceproject.dto.response;

public record FeedbackResponse(
        String feedbackType,
        String feedbackText,
        int feedbackNote
) {
}
