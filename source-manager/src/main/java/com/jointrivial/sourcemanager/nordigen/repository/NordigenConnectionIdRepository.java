package com.jointrivial.sourcemanager.nordigen.repository;

import com.jointrivial.sourcemanager.nordigen.model.entity.NordigenConnectionId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NordigenConnectionIdRepository extends JpaRepository<NordigenConnectionId, String> {

    NordigenConnectionId getSourceIdentifierByReferenceId(String referenceId);
}
