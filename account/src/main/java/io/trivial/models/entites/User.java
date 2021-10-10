package io.trivial.models.entites;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User extends BaseEntity {

    private String email;
    private String password;
    private Address address;
    private List<KeyOrganization> keysOrganization;

    public User() {
    }

    @Column(name = "email", nullable = false, unique = true, updatable = false)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "password", nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "users_addresses",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "address_id", referencedColumnName = "id"))
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @OneToMany(fetch = FetchType.EAGER)
	public List<KeyOrganization> getKeysOrganization() {
		return keysOrganization;
	}

	public void setKeysOrganization(List<KeyOrganization> keysOrganization) {
		this.keysOrganization = keysOrganization;
	}
    
}
