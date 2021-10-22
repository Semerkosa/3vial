package com.jointrivial.server.models.entities;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "data")
public class Data extends BaseEntity {
    private String email;
    private LocalDateTime timestamp = LocalDateTime.now();
    private Set<Answer> answers_1 = new HashSet<>();
    private String answer_2;
    private String answer_3;
    private TextInput_1 textInput_1;
    private TextInput_2 textInput_2;


    public Data() {
    }

    @Email(regexp = "^(.+)@(\\S+)$")
    @Column(unique = true, nullable = false)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @OneToMany(mappedBy = "data", targetEntity = Answer.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    public Set<Answer> getAnswers_1() {
        return answers_1;
    }

    public void setAnswers_1(Set<Answer> answers_1) {
        this.answers_1 = answers_1;
    }

    public String getAnswer_2() {
        return answer_2;
    }

    public void setAnswer_2(String answer_2) {
        this.answer_2 = answer_2;
    }

    public String getAnswer_3() {
        return answer_3;
    }

    public void setAnswer_3(String answer_3) {
        this.answer_3 = answer_3;
    }

    @OneToOne(mappedBy = "data", targetEntity = TextInput_1.class)
    @PrimaryKeyJoinColumn
    public TextInput_1 getTextInput_1() {
        return textInput_1;
    }

    public void setTextInput_1(TextInput_1 textInput_1) {
        this.textInput_1 = textInput_1;
    }

    @OneToOne(mappedBy = "data", targetEntity = TextInput_2.class)
    @PrimaryKeyJoinColumn
    public TextInput_2 getTextInput_2() {
        return textInput_2;
    }

    public void setTextInput_2(TextInput_2 textInput_2) {
        this.textInput_2 = textInput_2;
    }
}
