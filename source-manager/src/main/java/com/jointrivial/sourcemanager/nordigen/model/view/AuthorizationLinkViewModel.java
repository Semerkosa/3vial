package com.jointrivial.sourcemanager.nordigen.model.view;

public class AuthorizationLinkViewModel {

    private String link;

    public AuthorizationLinkViewModel() {
    }

    public AuthorizationLinkViewModel(String authorizationLink) {
        this.link = authorizationLink;
    }

    public String getLink() {
        return link;
    }

    public AuthorizationLinkViewModel setLink(String link) {
        this.link = link;
        return this;
    }
}
