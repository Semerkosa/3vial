package com.jointrivial.sourcemanager.nordigen.model.service;

import com.google.gson.annotations.Expose;

import java.time.LocalDateTime;
import java.util.List;

public class RequisitionServiceModel extends BaseServiceModel {

    @Expose
    private String created;
    @Expose
    private String redirect;
    @Expose
    private String status;
    @Expose
    private String institution_id;
    @Expose
    private String agreement;
    @Expose
    private String reference;
    @Expose
    private List<String> accounts;
    @Expose
    private String link;
    @Expose
    private String ssn;
    @Expose
    private boolean account_selection;

    public RequisitionServiceModel() {
    }

    public String getCreated() {
        return created;
    }

    public RequisitionServiceModel setCreated(String created) {
        this.created = created;
        return this;
    }

    public String getRedirect() {
        return redirect;
    }

    public RequisitionServiceModel setRedirect(String redirect) {
        this.redirect = redirect;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public RequisitionServiceModel setStatus(String status) {
        this.status = status;
        return this;
    }

    public String getInstitution_id() {
        return institution_id;
    }

    public RequisitionServiceModel setInstitution_id(String institution_id) {
        this.institution_id = institution_id;
        return this;
    }

    public String getAgreement() {
        return agreement;
    }

    public RequisitionServiceModel setAgreement(String agreement) {
        this.agreement = agreement;
        return this;
    }

    public String getReference() {
        return reference;
    }

    public RequisitionServiceModel setReference(String reference) {
        this.reference = reference;
        return this;
    }

    public List<String> getAccounts() {
        return accounts;
    }

    public RequisitionServiceModel setAccounts(List<String> accounts) {
        this.accounts = accounts;
        return this;
    }

    public String getLink() {
        return link;
    }

    public RequisitionServiceModel setLink(String link) {
        this.link = link;
        return this;
    }

    public String getSsn() {
        return ssn;
    }

    public RequisitionServiceModel setSsn(String ssn) {
        this.ssn = ssn;
        return this;
    }

    public boolean isAccount_selection() {
        return account_selection;
    }

    public RequisitionServiceModel setAccount_selection(boolean account_selection) {
        this.account_selection = account_selection;
        return this;
    }
}
