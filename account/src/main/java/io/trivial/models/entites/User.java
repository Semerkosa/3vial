package io.trivial.models.entites;

import javax.persistence.*;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "users")
public class User extends BaseEntity implements UserDetails {

    private String email;
    private String password;
    private Address address;
    private List<KeyOrganization> keysOrganization;
    private String role;
    private String privilege;
    private List<Role> roles;

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

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	public List<KeyOrganization> getKeysOrganization() {
		return keysOrganization;
	}

	public void setKeysOrganization(List<KeyOrganization> keysOrganization) {
		this.keysOrganization = keysOrganization;
	}

	@Column(name = "role", nullable = false)
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Column(name = "privilege", nullable = false)
	public String getPrivilege() {
		return privilege;
	}

	public void setPrivilege(String privilege) {
		this.privilege = privilege;
	}

	@Transient
	@Override
	public List<GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(this.getRole()));
		return authorities;
	}

	@Transient
	@Override
	public String getUsername() {
		return this.email;
	}

	@Transient
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Transient
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Transient
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Transient
	@Override
	public boolean isEnabled() {
		return true;
	}
	
}
