package com.jointrivial.server.models.entities;

import javax.persistence.*;

@Entity
@Table(name = "text_input_second_question")
public class TextInputSecondQuestion extends TextInput {

    public TextInputSecondQuestion(String input, Survey survey) {
        super(input, survey);
    }

    public TextInputSecondQuestion() {
    }
}
