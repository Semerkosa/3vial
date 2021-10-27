package com.jointrivial.server.repositories;

import com.jointrivial.server.models.entities.TextInput;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TextInputRepository extends JpaRepository<TextInput,String> {

}
