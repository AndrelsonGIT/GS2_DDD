package fiap.codecraft.model.feedback;

import jakarta.persistence.*;

@Entity
@Table(name = "TB_FEEDBACK_GS")
public class FeedbackEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "categoria")
    @Enumerated(EnumType.STRING)
    private FeedbackCategory category;

    @Column(name = "texto")
    private String text;

    @Column(name = "nota")
    private int grade;

    public FeedbackEntity() {
    }

    public FeedbackEntity(Integer id, FeedbackCategory category, String text, int grade) {
        this.id = id;
        this.category = category;
        this.text = text;
        this.grade = grade;
    }

    public Integer getId() {
        return id;
    }

    public FeedbackCategory getCategory() {
        return category;
    }

    public void setCategory(FeedbackCategory category) {
        this.category = category;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
