package com.jointrivial.server.models.entities;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "question_1_answers")
public class Answer extends BaseEntity{
    private transient Survey survey;
    private String value;

    public Answer() {
    }

    public Answer(String value, Survey survey) {
        this.value=value;
        this.survey=survey;
    }
    @NotEmpty
    @Column(columnDefinition = "varchar(1)")
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    @ManyToOne
    @JoinColumn(name = "survey_id", referencedColumnName = "data_id")
    public Survey getSurvey() {
        return survey;
    }

    public void setSurvey(Survey survey) {
        this.survey = survey;
    }
}
