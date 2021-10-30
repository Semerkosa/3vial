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
    private TextInput1 textInput1;
    private TextInput2 textInput2;

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

    public void setAnswers1(Set<Answer> answers_1) {
        this.answers1 = answers_1;
    }

    @Column(name = "answer_2")
    public String getAnswer2() {
        return answer2;
    }

    public void setAnswer2(String answer_2) {
        this.answer2 = answer_2;
    }

    @Column(name = "answer_3")
    public String getAnswer3() {
        return answer3;
    }

    public void setAnswer3(String answer_3) {
        this.answer3 = answer_3;
    }

    @OneToOne(mappedBy = "survey", targetEntity = TextInput1.class)
    @PrimaryKeyJoinColumn
    public TextInput1 getTextInput1() {
        return textInput1;
    }

    public void setTextInput1(TextInput1 textInput_1) {
        this.textInput1 = textInput_1;
    }

    @OneToOne(mappedBy = "survey", targetEntity = TextInput2.class)
    @PrimaryKeyJoinColumn
    public TextInput2 getTextInput2() {
        return textInput2;
    }

    public void setTextInput2(TextInput2 textInput_2) {
        this.textInput2 = textInput_2;
    }
}
