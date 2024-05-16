package wedsan.salesforceproject.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "TB_USUARIO_FEEDBACK")
public class FeedbackEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String feedbackType;

    private String feedbackText;

    private int feedbackNote;

    private String userFeedbackEmail;

    public FeedbackEntity() {
    }

    public FeedbackEntity(Long id, String feedbackType, String feedbackText, int feedbackNote, String userFeedbackEmail) {
        this.id = id;
        this.feedbackType = feedbackType;
        this.feedbackText = feedbackText;
        this.feedbackNote = feedbackNote;
        this.userFeedbackEmail = userFeedbackEmail;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFeedbackType() {
        return feedbackType;
    }

    public void setFeedbackType(String feedbackType) {
        this.feedbackType = feedbackType;
    }

    public String getFeedbackText() {
        return feedbackText;
    }

    public void setFeedbackText(String feedbackText) {
        this.feedbackText = feedbackText;
    }

    public int getFeedbackNote() {
        return feedbackNote;
    }

    public void setFeedbackNote(int feedbackNote) {
        this.feedbackNote = feedbackNote;
    }

    public String getUserFeedbackEmail() {
        return userFeedbackEmail;
    }

    public void setUserFeedbackEmail(String userFeedbackEmail) {
        this.userFeedbackEmail = userFeedbackEmail;
    }
}
