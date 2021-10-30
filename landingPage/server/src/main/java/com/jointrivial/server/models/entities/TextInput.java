package com.jointrivial.server.models.entities;

import javax.persistence.*;

@MappedSuperclass
public abstract class TextInput extends BaseEntity{
    private String value;
    private transient Survey survey;

    public TextInput(String value, Survey survey) {
        this.value = value;
        this.survey=survey;
    }

    public TextInput() {
    }

    public String getValue() {
        return value;
    }

    public void setValue(String input) {
        this.value = input;
    }

    @OneToOne
    @MapsId
    @JoinColumn(name = "survey_id", referencedColumnName = "data_id")
    public Survey getSurvey() {
        return survey;
    }

    public void setSurvey(Survey survey) {
        this.survey=survey;
    }
}
