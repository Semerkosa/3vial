package com.jointrivial.sourcemanager.nordigen.web.controller;

import com.google.gson.Gson;
import com.jointrivial.sourcemanager.nordigen.api.NordigenSourceLinkAPI;
import com.jointrivial.sourcemanager.nordigen.model.service.RequisitionServiceModel;
import com.jointrivial.sourcemanager.nordigen.model.service.SourceIdentifierServiceModel;
import com.jointrivial.sourcemanager.nordigen.model.view.AuthorizationLinkViewModel;
import com.jointrivial.sourcemanager.nordigen.model.view.BankViewModel;
import com.jointrivial.sourcemanager.nordigen.model.view.CountryViewModel;
import com.jointrivial.sourcemanager.nordigen.model.view.KeyOrganisationViewModel;
import com.jointrivial.sourcemanager.nordigen.service.BankService;
import com.jointrivial.sourcemanager.nordigen.service.CountryService;
import com.jointrivial.sourcemanager.nordigen.service.SourceIdentifierService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
public class NordigenController {

    private final CountryService countryService;
    private final BankService bankService;
    private final SourceIdentifierService sourceIdentifierService;
    private final NordigenSourceLinkAPI nordigen;
    private final ModelMapper mapper;
    private final Gson gson;

    public NordigenController(CountryService countryService, BankService bankService, SourceIdentifierService sourceIdentifierService, NordigenSourceLinkAPI nordigen, ModelMapper mapper, Gson gson) {
        this.countryService = countryService;
        this.bankService = bankService;
        this.sourceIdentifierService = sourceIdentifierService;
        this.nordigen = nordigen;
        this.mapper = mapper;
        this.gson = gson;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value = "/nordigen_countries",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CountryViewModel>> getAvailableCountries() {

        List<CountryViewModel> countryViewModels = countryService.getAllAvailableCountries();

        // TODO add exc handler

        return new ResponseEntity<>(countryViewModels, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value = "/banks/{countryCode}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<BankViewModel>> getAvailableBanks(
            @PathVariable(name = "countryCode") String country) throws InterruptedException, IOException, URISyntaxException {

        List<BankViewModel> bankViewModels = this.bankService.getAllBankIDsAndNamesForCountry(country);

        // TODO add exc handler

        return new ResponseEntity<>(bankViewModels, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value = "/create_requisition",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AuthorizationLinkViewModel> getAuthorizationLink(
            @RequestHeader("User-Token") String userToken,
            @RequestHeader("Bank-Id") String bankId,
            @RequestHeader("Redirect-Link-Prefix") String redirectLinkPrefix) throws IOException, InterruptedException {

        // TODO check if userToken is valid with a request to account microservice

        AuthorizationLinkViewModel authorizationLinkViewModel =
                this.sourceIdentifierService.getAuthorizationLink(userToken, bankId, redirectLinkPrefix);

        // TODO add exc handler

        return new ResponseEntity<>(authorizationLinkViewModel, HttpStatus.OK);
    }

    @GetMapping(value = "/verify-requisition",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAuthorizationLink(@RequestHeader("User-Token") String userToken
            ,@RequestHeader("Reference-Id") String referenceId) throws IOException, InterruptedException {

        SourceIdentifierServiceModel currentSourceIdentifier = this.sourceIdentifierService.getSourceIdentifierByReferenceId(referenceId);

        String requisitionById = this.nordigen.getRequisitionById(currentSourceIdentifier.getRequisitionId());

        RequisitionServiceModel requisitionJson = this.gson.fromJson(requisitionById, RequisitionServiceModel.class);

        String institution_id = requisitionJson.getInstitution_id();
        List<String> accounts = requisitionJson.getAccounts();

        
        return null;
    }

}
