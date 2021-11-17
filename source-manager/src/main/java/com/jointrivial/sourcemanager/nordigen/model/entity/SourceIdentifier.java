package com.jointrivial.sourcemanager.nordigen.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "source_identifiers")
public class SourceIdentifier {

    private String referenceId;
    private String requisitionId;

    public SourceIdentifier() {
    }

    @Id
    @Column(name = "reference_id", nullable = false, unique = true)
    public String getReferenceId() {
        return referenceId;
    }

    public SourceIdentifier setReferenceId(String referenceId) {
        this.referenceId = referenceId;
        return this;
    }

    @Column(name = "requisition_id")
    public String getRequisitionId() {
        return requisitionId;
    }

    public SourceIdentifier setRequisitionId(String requisitionId) {
        this.requisitionId = requisitionId;
        return this;
    }
}
