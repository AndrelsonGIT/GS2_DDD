package fiap.codecraft.DTO.request.Feedback;

import fiap.codecraft.model.feedback.FeedbackCategory;

public record FeedbackCreateDTORequest(
        int grade,
        String text,
        FeedbackCategory category
) {
}
