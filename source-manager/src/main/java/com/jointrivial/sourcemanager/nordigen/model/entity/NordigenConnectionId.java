package com.jointrivial.sourcemanager.nordigen.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "nordigen_connection_ids")
public class NordigenConnectionId {

    private String referenceId;
    private String requisitionId;
    private String bankName;

    public NordigenConnectionId() {
    }

    @Id
    @Column(name = "reference_id", nullable = false, unique = true)
    public String getReferenceId() {
        return referenceId;
    }

    public NordigenConnectionId setReferenceId(String referenceId) {
        this.referenceId = referenceId;
        return this;
    }

    @Column(name = "requisition_id")
    public String getRequisitionId() {
        return requisitionId;
    }

    public NordigenConnectionId setRequisitionId(String requisitionId) {
        this.requisitionId = requisitionId;
        return this;
    }

    @Column(name = "bank_name")
    public String getBankName() {
        return bankName;
    }

    public NordigenConnectionId setBankName(String bankName) {
        this.bankName = bankName;
        return this;
    }
}
