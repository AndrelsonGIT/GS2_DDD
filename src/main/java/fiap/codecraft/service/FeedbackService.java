package fiap.codecraft.service;

import fiap.codecraft.DTO.request.Feedback.FeedbackCreateDTORequest;
import fiap.codecraft.model.feedback.FeedbackEntity;
import fiap.codecraft.repository.FeedbackRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackService {

    private FeedbackRepository feedbackRepository;

    public FeedbackService(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    public FeedbackEntity createFeedback(FeedbackCreateDTORequest feedbackToBeCreated){
        FeedbackEntity feedbackEntity = new FeedbackEntity(
                null, feedbackToBeCreated.category(), feedbackToBeCreated.text(), feedbackToBeCreated.grade());

        return feedbackRepository.save(feedbackEntity);
    }

    public List<FeedbackEntity> getAll(){
        return feedbackRepository.findAll();
    }
}
