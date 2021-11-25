package com.jointrivial.sourcemanager.nordigen.service;

import com.jointrivial.sourcemanager.nordigen.model.entity.SourceIdentifier;
import com.jointrivial.sourcemanager.nordigen.model.service.SourceIdentifierServiceModel;
import com.jointrivial.sourcemanager.nordigen.model.view.AuthorizationLinkViewModel;

import java.io.IOException;

public interface SourceIdentifierService {

    AuthorizationLinkViewModel getAuthorizationLink(String userToken, String bankId, String redirectLinkPrefix) throws IOException, InterruptedException;

    SourceIdentifierServiceModel getSourceIdentifierByReferenceId(String referenceId);

}
