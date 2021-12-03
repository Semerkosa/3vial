package com.jointrivial.sourcemanager.nordigen.model.view;

public class KeyOrganisationViewModel {

    private String institutionId;
    private String accountId;

    public KeyOrganisationViewModel(String institutionId, String accountId) {
        this.institutionId = institutionId;
        this.accountId = accountId;
    }

    public String getInstitutionId() {
        return institutionId;
    }

    public void setInstitutionId(String institutionId) {
        this.institutionId = institutionId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
}
