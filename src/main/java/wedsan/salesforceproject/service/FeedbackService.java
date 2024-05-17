package wedsan.salesforceproject.service;

import org.springframework.stereotype.Service;
import wedsan.salesforceproject.dto.request.FeedbackRequest;
import wedsan.salesforceproject.model.FeedbackEntity;
import wedsan.salesforceproject.repository.FeedBackRepository;

@Service
public class FeedbackService {

    private FeedBackRepository feedBackRepository;

    public FeedbackService(FeedBackRepository feedBackRepository) {
        this.feedBackRepository = feedBackRepository;
    }

    public FeedbackEntity createFeedback(FeedbackRequest feedbackRequest) {
        FeedbackEntity feedbackEntityToBeSaved = new FeedbackEntity();
        feedbackEntityToBeSaved.setFeedbackType(feedbackRequest.feedbackType());
        feedbackEntityToBeSaved.setFeedbackText(feedbackRequest.feedbackText());
        feedbackEntityToBeSaved.setFeedbackNote(feedbackRequest.feedbackNote());

        System.out.println(feedbackEntityToBeSaved.getFeedbackType());

        if(feedbackRequest.feedbackUserEmail() != null){
            feedbackEntityToBeSaved.setUserFeedbackEmail(feedbackRequest.feedbackUserEmail());
        }

        return feedBackRepository.save(feedbackEntityToBeSaved);
    }
}
