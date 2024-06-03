package fiap.codecraft.controller;

import fiap.codecraft.DTO.request.Feedback.FeedbackCreateDTORequest;
import fiap.codecraft.DTO.response.feedback.FeedbackDTOResponse;
import fiap.codecraft.model.feedback.FeedbackEntity;
import fiap.codecraft.service.FeedbackService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public ResponseEntity<List<FeedbackDTOResponse>> getFeedback(){
         List<FeedbackDTOResponse> feedbackResponseList = feedbackService.getAll()
                 .stream()
                 .map((FeedbackDTOResponse::new))
                 .toList();

         return ResponseEntity.status(HttpStatus.OK).body(feedbackResponseList);
    }
}
