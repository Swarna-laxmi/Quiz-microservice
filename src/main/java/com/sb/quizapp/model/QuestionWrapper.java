package com.sb.quizapp.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class QuestionWrapper {
    public QuestionWrapper(Long id, String questionText, String option_A, String option_B, String option_C, String option_D) {
        this.id = id;
        this.questionText = questionText;
        this.option_A = option_A;
        this.option_B = option_B;
        this.option_C = option_C;
        this.option_D = option_D;
    }

    public QuestionWrapper() {
    }

    public Long getId() {
        return id;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String getOption_A() {
        return option_A;
    }

    public String getOption_B() {
        return option_B;
    }

    public String getOption_C() {
        return option_C;
    }

    public String getOption_D() {
        return option_D;
    }

    private Long id;
    private String questionText;
    private String option_A;

    private String option_B;

    private String option_C;
    private String option_D;
}
