package com.jointrivial.sourcemanager.nordigen.service;

import com.jointrivial.sourcemanager.nordigen.model.view.AuthorizationLinkViewModel;

public interface SourceIdentifierService {

    AuthorizationLinkViewModel getAuthorizationLink(String bankId, String redirectLinkPrefix);
}
