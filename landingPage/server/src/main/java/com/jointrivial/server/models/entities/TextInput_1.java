package com.jointrivial.server.models.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "text_input_1")
public class TextInput_1 extends TextInput {

    public TextInput_1() {
    }

    public TextInput_1(String input, Data data) {
        super(input, data);
    }
}
