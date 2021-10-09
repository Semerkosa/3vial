package io.trivial.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.trivial.models.entites.KeyOrganization;

@Repository
public interface KeyOrganizationRepository extends JpaRepository<KeyOrganization, String> {

}
