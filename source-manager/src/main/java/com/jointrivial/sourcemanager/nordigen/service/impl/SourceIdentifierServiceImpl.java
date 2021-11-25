package com.jointrivial.sourcemanager.nordigen.service.impl;

import com.google.gson.Gson;
import com.jointrivial.sourcemanager.nordigen.api.NordigenSourceLinkAPI;
import com.jointrivial.sourcemanager.nordigen.model.entity.SourceIdentifier;
import com.jointrivial.sourcemanager.nordigen.model.service.RequisitionServiceModel;
import com.jointrivial.sourcemanager.nordigen.model.service.SourceIdentifierServiceModel;
import com.jointrivial.sourcemanager.nordigen.model.view.AuthorizationLinkViewModel;
import com.jointrivial.sourcemanager.nordigen.repository.SourceIdentifierRepository;
import com.jointrivial.sourcemanager.nordigen.service.SourceIdentifierService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.UUID;

@Service
public class SourceIdentifierServiceImpl implements SourceIdentifierService {

    private final Gson gson;
    private final NordigenSourceLinkAPI api;
    private final SourceIdentifierRepository sourceIdentifierRepository;
    private final ModelMapper mapper;

    public SourceIdentifierServiceImpl(Gson gson, NordigenSourceLinkAPI api, SourceIdentifierRepository sourceIdentifierRepository, ModelMapper mapper) {
        this.gson = gson;
        this.api = api;
        this.sourceIdentifierRepository = sourceIdentifierRepository;
        this.mapper = mapper;
    }

    @Override
    public AuthorizationLinkViewModel getAuthorizationLink(String userToken, String bankId, String redirectLinkPrefix) throws IOException, InterruptedException {
        String reference = UUID.randomUUID().toString();
        String redirectUrl = redirectLinkPrefix + "?userToken=" + userToken + "&referenceId=" + reference;

        String requisitionJson = this.api.createRequisition(bankId, reference, redirectUrl);

        if (requisitionJson == null) {
            // TODO
        }

        RequisitionServiceModel requisitionServiceModel =
                this.gson.fromJson(requisitionJson, RequisitionServiceModel.class);

        SourceIdentifier source = new SourceIdentifier();
        source.setReferenceId(reference)
                .setRequisitionId(requisitionServiceModel.getId());

        this.sourceIdentifierRepository.saveAndFlush(source);

        return new AuthorizationLinkViewModel(requisitionServiceModel.getLink());
    }

    @Override
    public SourceIdentifierServiceModel getSourceIdentifierByReferenceId(String referenceId) {

        SourceIdentifier sourceIdentifierByReferenceId = this.sourceIdentifierRepository.getSourceIdentifierByReferenceId(referenceId);

        return this.mapper.map(sourceIdentifierByReferenceId,SourceIdentifierServiceModel.class);
    }
}
