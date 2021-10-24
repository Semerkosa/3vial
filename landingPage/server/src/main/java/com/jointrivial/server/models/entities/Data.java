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
    private Set<Answer> answers1 = new HashSet<>();
    private String answer2;
    private String answer3;
    private TextInput1 textInput1;
    private TextInput2 textInput2;


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
    public Set<Answer> getAnswers1() {
        return answers1;
    }

    public void setAnswers1(Set<Answer> answers_1) {
        this.answers1 = answers_1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public void setAnswer2(String answer_2) {
        this.answer2 = answer_2;
    }

    public String getAnswer3() {
        return answer3;
    }

    public void setAnswer3(String answer_3) {
        this.answer3 = answer_3;
    }

    @OneToOne(mappedBy = "data", targetEntity = TextInput1.class)
    @PrimaryKeyJoinColumn
    public TextInput1 getTextInput1() {
        return textInput1;
    }

    public void setTextInput1(TextInput1 textInput_1) {
        this.textInput1 = textInput_1;
    }

    @OneToOne(mappedBy = "data", targetEntity = TextInput2.class)
    @PrimaryKeyJoinColumn
    public TextInput2 getTextInput2() {
        return textInput2;
    }

    public void setTextInput2(TextInput2 textInput_2) {
        this.textInput2 = textInput_2;
    }
}
