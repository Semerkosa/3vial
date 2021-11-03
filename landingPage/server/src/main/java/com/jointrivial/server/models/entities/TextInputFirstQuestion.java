package com.jointrivial.server.models.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "text_input_first_question")
public class TextInputFirstQuestion extends TextInput {

    public TextInputFirstQuestion() {
    }

    public TextInputFirstQuestion(String input, Survey survey) {
        super(input, survey);
    }
}
