package com.jointrivial.sourcemanager.nordigen.service;

import com.jointrivial.sourcemanager.nordigen.model.service.NordigenConnectionIdServiceModel;
import com.jointrivial.sourcemanager.nordigen.model.view.AuthorizationLinkViewModel;

import java.io.IOException;

public interface NordigenConnectionIdService {

    AuthorizationLinkViewModel getAuthorizationLink(String userToken, String bankId, String bankName, String redirectLinkPrefix) throws IOException, InterruptedException;

    NordigenConnectionIdServiceModel getSourceIdentifierByReferenceId(String referenceId);

}
