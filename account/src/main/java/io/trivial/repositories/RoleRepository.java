package io.trivial.repositories;

import io.trivial.models.entites.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Deprecated
@Repository
public interface RoleRepository extends JpaRepository<Role, String> {
}
