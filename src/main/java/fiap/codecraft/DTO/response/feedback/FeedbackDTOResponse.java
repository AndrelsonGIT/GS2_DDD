package fiap.codecraft.DTO.response.feedback;

import fiap.codecraft.model.feedback.FeedbackCategory;
import fiap.codecraft.model.feedback.FeedbackEntity;

public record FeedbackDTOResponse(
        int id,
        FeedbackCategory feedbackCategory,
        String text,
        int grade
) {
    public FeedbackDTOResponse(FeedbackEntity feedbackEntity) {
        this(feedbackEntity.getId(), feedbackEntity.getCategory(), feedbackEntity.getText(), feedbackEntity.getGrade());
    }
}
