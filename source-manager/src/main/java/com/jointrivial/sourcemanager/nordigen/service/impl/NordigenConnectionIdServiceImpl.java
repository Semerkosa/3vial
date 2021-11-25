package com.jointrivial.sourcemanager.nordigen.service.impl;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.jointrivial.sourcemanager.nordigen.api.NordigenSourceLinkAPI;
import com.jointrivial.sourcemanager.nordigen.model.entity.NordigenConnectionId;
import com.jointrivial.sourcemanager.nordigen.model.service.NordigenConnectionIdServiceModel;
import com.jointrivial.sourcemanager.nordigen.model.service.RequisitionServiceModel;
import com.jointrivial.sourcemanager.nordigen.model.view.AuthorizationLinkViewModel;
import com.jointrivial.sourcemanager.nordigen.repository.NordigenConnectionIdRepository;
import com.jointrivial.sourcemanager.nordigen.service.NordigenConnectionIdService;
import okhttp3.*;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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

    @Override
    public HttpStatus verifyRequisition(RequisitionServiceModel requisitionJson, NordigenConnectionIdServiceModel currentSourceIdentifier, String userToken) {

        JsonObject keysOrganisationJson = new JsonObject();

        JsonArray jsonArray = new JsonArray();
        requisitionJson.getAccounts().forEach(e->{

            JsonObject current = new JsonObject();
            current.addProperty("organizationName",currentSourceIdentifier.getBankName());
            current.addProperty("organizationKey",e);
            jsonArray.add(current);

        });

        //Beautify the JSON
        String json = new Gson().toJson(keysOrganisationJson);
        json = json.replaceAll("\\\\","");
        json = json.replace("\"[", "[");
        json = json.replace("]\"", "]");


        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType,json);
        Request request = new Request.Builder()
                .url("http://localhost:8084/user/account/provider_api_keys")
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .addHeader("User-Token", userToken)
                .build();

        try {
            Response response = client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }

        return HttpStatus.OK;
    }
}
