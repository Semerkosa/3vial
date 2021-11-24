package com.jointrivial.sourcemanager.nordigen.repository;

import com.jointrivial.sourcemanager.nordigen.model.entity.SourceIdentifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SourceIdentifierRepository extends JpaRepository<SourceIdentifier, String> {

}
