package com.jointrivial.sourcemanager.nordigen.service.impl;

import com.google.gson.Gson;
import com.jointrivial.sourcemanager.nordigen.api.NordigenSourceLinkAPI;
import com.jointrivial.sourcemanager.enums.ErrorMessages;
import com.jointrivial.sourcemanager.exceptions.NordigenRequisitionNotFoundException;
import com.jointrivial.sourcemanager.nordigen.model.entity.SourceIdentifier;
import com.jointrivial.sourcemanager.nordigen.model.service.RequisitionServiceModel;
import com.jointrivial.sourcemanager.nordigen.model.view.AuthorizationLinkViewModel;
import com.jointrivial.sourcemanager.nordigen.repository.SourceIdentifierRepository;
import com.jointrivial.sourcemanager.nordigen.service.SourceIdentifierService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.UUID;

@Service
public class SourceIdentifierServiceImpl implements SourceIdentifierService {

    private final Gson gson;
    private final NordigenSourceLinkAPI api;
    private final SourceIdentifierRepository sourceIdentifierRepository;

    public SourceIdentifierServiceImpl(Gson gson, NordigenSourceLinkAPI api, SourceIdentifierRepository sourceIdentifierRepository) {
        this.gson = gson;
        this.api = api;
        this.sourceIdentifierRepository = sourceIdentifierRepository;
    }

    @Override
    public AuthorizationLinkViewModel getAuthorizationLink(String userToken, String bankId, String redirectLinkPrefix) throws IOException, InterruptedException {
        String reference = UUID.randomUUID().toString();
        String redirectUrl = redirectLinkPrefix + "?userToken=" + userToken + "&referenceId=" + reference;

        String requisitionJson = this.api.createRequisition(bankId, reference, redirectUrl);

        if (requisitionJson == null) {
            throw new NordigenRequisitionNotFoundException(ErrorMessages.NORDIGEN_REQUISITION_NOT_FOUND.getErrorMessage());
        }

        RequisitionServiceModel requisitionServiceModel =
                this.gson.fromJson(requisitionJson, RequisitionServiceModel.class);

        SourceIdentifier source = new SourceIdentifier();
        source.setReferenceId(reference)
                .setRequisitionId(requisitionServiceModel.getId());

        this.sourceIdentifierRepository.saveAndFlush(source);

        return new AuthorizationLinkViewModel(requisitionServiceModel.getLink());
    }
}
