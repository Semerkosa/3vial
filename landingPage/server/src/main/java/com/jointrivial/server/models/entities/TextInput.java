package com.jointrivial.server.models.entities;

import javax.persistence.*;

@MappedSuperclass
public abstract class TextInput extends BaseEntity{
    private String value;
    private transient Data data;

    public TextInput(String value, Data data) {
        this.value = value;
        this.data = data;
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
    @JoinColumn(name = "data_id", referencedColumnName = "id")
    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
