package io.trivial.models.entites;

import javax.persistence.*;

import io.trivial.enums.RoleEnum;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Deprecated
@Entity
@Table(name = "roles")
public class Role extends BaseEntity {

    private String name;
    private List<Privilege> privileges;

    public Role() {
    }

    public Role(String name, List<Privilege> privileges) {
        this.name = name;
        this.privileges = privileges;
    }

	@Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    public List<Privilege> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(List<Privilege> privileges) {
        this.privileges = privileges;
    }
}