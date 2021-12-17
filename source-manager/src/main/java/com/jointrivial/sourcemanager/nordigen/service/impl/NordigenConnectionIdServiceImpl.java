package com.jointrivial.sourcemanager.nordigen.service.impl;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.jointrivial.sourcemanager.enums.ErrorMessages;
import com.jointrivial.sourcemanager.exceptions.NordigenRequisitionNotFoundException;
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
import java.util.UUID;

import static com.jointrivial.sourcemanager.nordigen.constants.ApiURLs.*;

@Service
public class NordigenConnectionIdServiceImpl implements NordigenConnectionIdService {

    private final Gson gson;
    private final NordigenSourceLinkAPI api;
    private final NordigenConnectionIdRepository nordigenConnectionIdRepository;
    private final ModelMapper mapper;
    private final NordigenSourceLinkAPI nordigen;

    public NordigenConnectionIdServiceImpl(Gson gson, NordigenSourceLinkAPI api, NordigenConnectionIdRepository nordigenConnectionIdRepository, ModelMapper mapper, NordigenSourceLinkAPI nordigen) {
        this.gson = gson;
        this.api = api;
        this.nordigenConnectionIdRepository = nordigenConnectionIdRepository;
        this.mapper = mapper;
        this.nordigen = nordigen;
    }

    @Override
    public AuthorizationLinkViewModel getAuthorizationLink(String userToken, String bankId, String bankName, String redirectLinkPrefix) throws IOException, InterruptedException {
        String reference = UUID.randomUUID().toString();
        // TODO: See if the prefix link comes with '/' in the end:
        String redirectUrl = redirectLinkPrefix + "/" + userToken;

        String requisitionJson = this.api.createRequisition(bankId, reference, redirectUrl);

        if (requisitionJson == null) {
            System.out.println('m');
            throw new NordigenRequisitionNotFoundException(ErrorMessages.NORDIGEN_REQUISITION_NOT_FOUND.getErrorMessage());
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
    public HttpStatus verifyRequisition(String referenceId, String userToken) throws IOException, InterruptedException {

        NordigenConnectionIdServiceModel currentSourceIdentifier = this.getSourceIdentifierByReferenceId(referenceId);

        String requisitionById = this.nordigen.getRequisitionById(currentSourceIdentifier.getRequisitionId());

        JsonObject keysOrganisationJson = new JsonObject();

        JsonArray jsonArray = new JsonArray();
        this.gson.fromJson(requisitionById, RequisitionServiceModel.class).getAccounts().forEach(e->{
            JsonObject current = new JsonObject();
            current.addProperty("organizationName", currentSourceIdentifier.getBankName());
            current.addProperty("organizationKey", e);
            jsonArray.add(current);
        });

        keysOrganisationJson.add("keysOrganisation",jsonArray);
        //Beautify the JSON
        String json = new Gson().toJson(keysOrganisationJson);
        json = json.replaceAll("\\\\","");
        json = json.replace("\"[", "[");
        json = json.replace("]\"", "]");


        OkHttpClient accountService = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, json);
        Request post_provider_api_keys = new Request.Builder()
                .url(ACCOUNT_PROVIDE_API_KEYS)
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .addHeader("User-Token", userToken)
                .build();

        Response response;
        try {
            response = accountService.newCall(post_provider_api_keys).execute();
        } catch (IOException e) {
            e.printStackTrace();
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }

        return HttpStatus.valueOf(response.code());
    }
}
