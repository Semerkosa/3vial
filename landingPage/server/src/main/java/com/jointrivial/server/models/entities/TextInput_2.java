package com.jointrivial.server.models.entities;

import javax.persistence.*;

@Entity
@Table(name = "text_input_2")
public class TextInput_2 extends TextInput {

    public TextInput_2(String input, Data data) {
        super(input, data);
    }

    public TextInput_2() {
    }
}
