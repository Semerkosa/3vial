package com.jointrivial.sourcemanager.nordigen.service.impl;

import com.google.gson.Gson;
import com.jointrivial.sourcemanager.nordigen.api.NordigenSourceLinkAPI;
import com.jointrivial.sourcemanager.nordigen.model.view.AuthorizationLinkViewModel;
import com.jointrivial.sourcemanager.nordigen.service.SourceIdentifierService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SourceIdentifierServiceImpl implements SourceIdentifierService {

    private final Gson gson;
    private final NordigenSourceLinkAPI api;

    public SourceIdentifierServiceImpl(Gson gson, NordigenSourceLinkAPI api) {
        this.gson = gson;
        this.api = api;
    }

    @Override
    public AuthorizationLinkViewModel getAuthorizationLink(String bankId, String redirectLinkPrefix) {
        UUID reference = UUID.randomUUID();



        return null;
    }
}
