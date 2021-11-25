package com.jointrivial.sourcemanager.nordigen.service.impl;

import com.google.gson.Gson;
import com.jointrivial.sourcemanager.nordigen.api.NordigenSourceLinkAPI;
import com.jointrivial.sourcemanager.nordigen.model.entity.NordigenConnectionId;
import com.jointrivial.sourcemanager.nordigen.model.service.RequisitionServiceModel;
import com.jointrivial.sourcemanager.nordigen.model.service.NordigenConnectionIdServiceModel;
import com.jointrivial.sourcemanager.nordigen.model.view.AuthorizationLinkViewModel;
import com.jointrivial.sourcemanager.nordigen.repository.NordigenConnectionIdRepository;
import com.jointrivial.sourcemanager.nordigen.service.NordigenConnectionIdService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.UUID;

@Service
public class NordigenConnectionIdServiceImpl implements NordigenConnectionIdService {

    private final Gson gson;
    private final NordigenSourceLinkAPI api;
    private final NordigenConnectionIdRepository nordigenConnectionIdRepository;
    private final ModelMapper mapper;

    public NordigenConnectionIdServiceImpl(Gson gson, NordigenSourceLinkAPI api, NordigenConnectionIdRepository nordigenConnectionIdRepository, ModelMapper mapper) {
        this.gson = gson;
        this.api = api;
        this.nordigenConnectionIdRepository = nordigenConnectionIdRepository;
        this.mapper = mapper;
    }

    @Override
    public AuthorizationLinkViewModel getAuthorizationLink(String userToken, String bankId, String bankName, String redirectLinkPrefix) throws IOException, InterruptedException {
        String reference = UUID.randomUUID().toString();
        String redirectUrl = redirectLinkPrefix + "?userToken=" + userToken + "&referenceId=" + reference;

        String requisitionJson = this.api.createRequisition(bankId, reference, redirectUrl);

        if (requisitionJson == null) {
            // TODO
        }

        RequisitionServiceModel requisitionServiceModel =
                this.gson.fromJson(requisitionJson, RequisitionServiceModel.class);

        NordigenConnectionId source = new NordigenConnectionId();
        source.setReferenceId(reference)
                .setRequisitionId(requisitionServiceModel.getId())
                .setBankName(bankName);

        this.nordigenConnectionIdRepository.saveAndFlush(source);

        return new AuthorizationLinkViewModel(requisitionServiceModel.getLink());
    }

    @Override
    public NordigenConnectionIdServiceModel getSourceIdentifierByReferenceId(String referenceId) {

        NordigenConnectionId nordigenConnectionIdByReferenceId = this.nordigenConnectionIdRepository.getRequisitionIdByReferenceId(referenceId);

        return this.mapper.map(nordigenConnectionIdByReferenceId, NordigenConnectionIdServiceModel.class);
    }
}
