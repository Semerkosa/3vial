package io.trivial.models.entites;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "privileges")
public class Privilege extends BaseEntity {

    private String name;

    public Privilege() {
    }

    public Privilege(String name) {
        this.name = name;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}