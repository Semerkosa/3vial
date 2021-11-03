package com.jointrivial.server.models.binding;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Set;


public class SurveyBindingModel {
    private String email;
    private Set<String> answers1;
    private String answer2;
    private String answer3;
    private String textInput1;
    private String textInput2;

    public SurveyBindingModel() {
        this.answers1 = new HashSet<>();
    }

    @NotEmpty
    public Set<String> getAnswers1() {
        return answers1;
    }

    public void setAnswers1(Set<String> answers1) {
        this.answers1 = answers1;
    }

    @Email(regexp = "^(.+)@(\\S+)$")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @NotEmpty
    public String getAnswer2() {
        return answer2;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    @NotEmpty
    public String getAnswer3() {
        return answer3;
    }

    public void setAnswer3(String answer3) {
        this.answer3 = answer3;
    }

    public String getTextInput1() {
        return textInput1;
    }

    public void setTextInput1(String textInput1) {
        this.textInput1 = textInput1;
    }

    public String getTextInput2() {
        return textInput2;
    }

    public void setTextInput2(String textInput2) {
        this.textInput2 = textInput2;
    }
}
