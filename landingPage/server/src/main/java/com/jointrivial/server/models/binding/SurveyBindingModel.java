package com.jointrivial.server.models.binding;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Set;


public class SurveyBindingModel {
    private String email;
    private Set<String> answers_1;
    private String answer_2;
    private String answer_3;
    private String text_input_1;
    private String text_input_2;

    public SurveyBindingModel() {
        this.answers_1 = new HashSet<>();
    }

    @NotEmpty
    public Set<String> getAnswers_1() {
        return answers_1;
    }

    public void setAnswers_1(Set<String> answers_1) {
        this.answers_1 = answers_1;
    }

    @Email(regexp = "^(.+)@(\\S+)$")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @NotEmpty
    public String getAnswer_2() {
        return answer_2;
    }

    public void setAnswer_2(String answer_2) {
        this.answer_2 = answer_2;
    }

    @NotEmpty
    public String getAnswer_3() {
        return answer_3;
    }

    public void setAnswer_3(String answer_3) {
        this.answer_3 = answer_3;
    }

    public String getText_input_1() {
        return text_input_1;
    }

    public void setText_input_1(String text_input_1) {
        this.text_input_1 = text_input_1;
    }

    public String getText_input_2() {
        return text_input_2;
    }

    public void setText_input_2(String text_input_2) {
        this.text_input_2 = text_input_2;
    }
}
