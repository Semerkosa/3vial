package com.jointrivial.sourcemanager.nordigen.service;

import com.jointrivial.sourcemanager.nordigen.model.service.NordigenConnectionIdServiceModel;
import com.jointrivial.sourcemanager.nordigen.model.service.RequisitionServiceModel;
import com.jointrivial.sourcemanager.nordigen.model.view.AuthorizationLinkViewModel;
import org.springframework.http.HttpStatus;

import java.io.IOException;

public interface NordigenConnectionIdService {

    AuthorizationLinkViewModel getAuthorizationLink(String userToken, String bankId, String bankName, String redirectLinkPrefix) throws IOException, InterruptedException;

    NordigenConnectionIdServiceModel getSourceIdentifierByReferenceId(String referenceId);

    HttpStatus verifyRequisition(RequisitionServiceModel requisitionJson, NordigenConnectionIdServiceModel currentSourceIdentifier, String token);
}
