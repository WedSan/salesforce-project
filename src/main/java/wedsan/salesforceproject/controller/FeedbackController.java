package wedsan.salesforceproject.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wedsan.salesforceproject.dto.request.FeedbackRequest;
import wedsan.salesforceproject.dto.response.FeedbackResponse;
import wedsan.salesforceproject.model.FeedbackEntity;
import wedsan.salesforceproject.service.FeedbackService;

import java.util.List;
import java.util.stream.Collectors;

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

    @GetMapping
    public ResponseEntity getAllFeedback(){
        List<FeedbackEntity> feedbackEntityList = feedbackService.getAllFeedback();
        List<FeedbackResponse> feedbackResponseList = feedbackEntityList.stream().map(e->{
           return new FeedbackResponse(e.getFeedbackType(), e.getFeedbackText(), e.getFeedbackNote());
        }).collect(Collectors.toList());

        return ResponseEntity.ok(feedbackResponseList);
    }
}
