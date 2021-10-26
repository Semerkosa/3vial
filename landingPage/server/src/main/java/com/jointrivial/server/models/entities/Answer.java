package com.jointrivial.server.models.entities;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "question_1_answers")
public class Answer extends BaseEntity{
    private transient Data data;
    private String value;

    public Answer() {
    }

    public Answer(String value, Data data) {
        this.value=value;
        this.data = data;
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
    @JoinColumn(name = "data_id", referencedColumnName = "id")
    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
