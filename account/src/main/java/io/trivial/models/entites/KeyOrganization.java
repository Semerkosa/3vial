package io.trivial.models.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "keys_organizations")
public class KeyOrganization extends BaseEntity {

    private String organizationName;
    private String organizationKey;

    public KeyOrganization() {
    }

    @Column(name = "organization_name", nullable = false, unique = true)
    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    @Column(name = "organization_key", nullable = false)
	public String getOrganizationKey() {
		return organizationKey;
	}

	public void setOrganizationKey(String organizationKey) {
		this.organizationKey = organizationKey;
	}
}
