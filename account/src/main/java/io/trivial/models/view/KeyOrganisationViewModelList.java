package io.trivial.models.view;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class KeyOrganisationViewModelList {

    private List<KeyOrganizationViewModel> keyOrganization;

    @JsonCreator
    public KeyOrganisationViewModelList(@JsonProperty("keysOrganisation") List<KeyOrganizationViewModel> list)  {
        this.keyOrganization = list;
    }

    public List<KeyOrganizationViewModel> getKeyOrganization() {
        return keyOrganization;
    }

    public void setKeyOrganization(List<KeyOrganizationViewModel> keyOrganization) {
        this.keyOrganization = keyOrganization;
    }

    @Override
    public String toString() {
        String keys = "{";
        for (KeyOrganizationViewModel keyOrganizationViewModel : keyOrganization) {
            keys += keyOrganizationViewModel.toString() + ", ";
        }
        keys += "}";
        return "KeyOrganisationViewModelList{" +
                "keyOrganization=" + keys +
                '}';
    }
}
