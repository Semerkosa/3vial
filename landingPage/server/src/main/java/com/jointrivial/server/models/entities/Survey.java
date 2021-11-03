package com.jointrivial.server.models.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "surveys")
public class Survey extends BaseEntity {
    private transient Data data;
    private Set<Answer> answers1 = new HashSet<>();
    private String answer2;
    private String answer3;
    private TextInputFirstQuestion textInputFirstQuestion;
    private TextInputSecondQuestion textInputSecondQuestion;

    public Survey() {
    }

    @OneToOne
    @MapsId
    @JoinColumn(name = "data_id", referencedColumnName = "id")
    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    @OneToMany(mappedBy = "survey", targetEntity = Answer.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    public Set<Answer> getAnswers1() {
        return answers1;
    }

    public void setAnswers1(Set<Answer> answers1) {
        this.answers1 = answers1;
    }

    @Column(name = "answer_2")
    public String getAnswer2() {
        return answer2;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    @Column(name = "answer_3")
    public String getAnswer3() {
        return answer3;
    }

    public void setAnswer3(String answer3) {
        this.answer3 = answer3;
    }

    @OneToOne(mappedBy = "survey", targetEntity = TextInputFirstQuestion.class)
    @PrimaryKeyJoinColumn
    public TextInputFirstQuestion getTextInput1() {
        return textInputFirstQuestion;
    }

    public void setTextInput1(TextInputFirstQuestion textInput1) {
        this.textInputFirstQuestion = textInput1;
    }

    @OneToOne(mappedBy = "survey", targetEntity = TextInputSecondQuestion.class)
    @PrimaryKeyJoinColumn
    public TextInputSecondQuestion getTextInput2() {
        return textInputSecondQuestion;
    }

    public void setTextInput2(TextInputSecondQuestion textInput2) {
        this.textInputSecondQuestion = textInput2;
    }
}
