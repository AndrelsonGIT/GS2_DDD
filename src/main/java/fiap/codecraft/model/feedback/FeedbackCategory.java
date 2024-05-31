package fiap.codecraft.model.feedback;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonAppend;

public enum FeedbackCategory {
    NAVIGATION("ChatBot"),

    WEB_PLATFORM("Plataforma Web");


    private final String feedbackString;

    FeedbackCategory(String statusString) {
        this.feedbackString = statusString;
    }

    @JsonValue
    public String getFeedbackCategory() {
        return feedbackString;
    }

    @JsonCreator
    public static FeedbackCategory forValue(String value) {
        for (FeedbackCategory category : FeedbackCategory.values()) {
            if(value.equals(category.feedbackString)) {
                return category;
            }
        }
        throw new IllegalArgumentException("Doesn't exist this value in feedback category: "+value);
    }


}
