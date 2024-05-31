package fiap.codecraft.controller;

import fiap.codecraft.DTO.request.Feedback.FeedbackCreateDTORequest;
import fiap.codecraft.DTO.response.feedback.FeedbackDTOResponse;
import fiap.codecraft.model.feedback.FeedbackEntity;
import fiap.codecraft.service.FeedbackService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("feedback")
public class FeebackController {

    private FeedbackService feedbackService;

    public FeebackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @PostMapping
    public ResponseEntity<FeedbackDTOResponse> createFeedback(@RequestBody FeedbackCreateDTORequest request){
        FeedbackEntity feedbackEntity = feedbackService.createFeedback(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(new FeedbackDTOResponse(feedbackEntity));
    }
}
