package wedsan.salesforceproject.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wedsan.salesforceproject.dto.request.FeedbackRequest;
import wedsan.salesforceproject.service.FeedbackService;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {

    private FeedbackService feedbackService;

    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @PostMapping
    public ResponseEntity createUser(@RequestBody @Valid FeedbackRequest feedbackRequest){
        feedbackService.createFeedback(feedbackRequest);
        return ResponseEntity.noContent().build();
    }
}
