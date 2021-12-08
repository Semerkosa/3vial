package com.jointrivial.sourcemanager.nordigen.web.controller;

import com.google.gson.Gson;
import com.jointrivial.sourcemanager.nordigen.api.NordigenSourceLinkAPI;
import com.jointrivial.sourcemanager.nordigen.model.service.RequisitionServiceModel;
import com.jointrivial.sourcemanager.nordigen.model.service.NordigenConnectionIdServiceModel;
import com.jointrivial.sourcemanager.nordigen.model.view.AuthorizationLinkViewModel;
import com.jointrivial.sourcemanager.nordigen.model.view.BankViewModel;
import com.jointrivial.sourcemanager.nordigen.model.view.CountryViewModel;
import com.jointrivial.sourcemanager.nordigen.service.BankService;
import com.jointrivial.sourcemanager.nordigen.service.CountryService;
import com.jointrivial.sourcemanager.nordigen.service.NordigenConnectionIdService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class NordigenController {

    private final CountryService countryService;
    private final BankService bankService;
    private final NordigenConnectionIdService nordigenConnectionIdService;

    public NordigenController(CountryService countryService, BankService bankService, NordigenConnectionIdService nordigenConnectionIdService, NordigenSourceLinkAPI nordigen, ModelMapper mapper, Gson gson) {
        this.countryService = countryService;
        this.bankService = bankService;
        this.nordigenConnectionIdService = nordigenConnectionIdService;
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
            @RequestHeader("Bank-Name") String bankName,
            @RequestHeader("Redirect-Link-Prefix") String redirectLinkPrefix) throws IOException, InterruptedException {

        // TODO check if userToken is valid with a request to account microservice
        AuthorizationLinkViewModel authorizationLinkViewModel =
                this.nordigenConnectionIdService.getAuthorizationLink(userToken, bankId, bankName, redirectLinkPrefix);

        // TODO add exc handler

        return new ResponseEntity<>(authorizationLinkViewModel, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value = "/verify_requisition",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public HttpStatus verifyRequisition(
            @RequestHeader("User-Token") String userToken,
            @RequestHeader("Reference-Id") String referenceId) throws IOException, InterruptedException {

        return this.nordigenConnectionIdService.verifyRequisition(referenceId,userToken);
    }

}
