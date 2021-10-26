package com.jointrivial.server.models.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "text_input_1")
public class TextInput1 extends TextInput {

    public TextInput1() {
    }

    public TextInput1(String input, Data data) {
        super(input, data);
    }
}
