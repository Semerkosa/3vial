package com.jointrivial.sourcemanager.nordigen.web.controller;

import com.jointrivial.sourcemanager.nordigen.model.view.BankViewModel;
import com.jointrivial.sourcemanager.nordigen.model.view.CountryViewModel;
import com.jointrivial.sourcemanager.nordigen.service.BankService;
import com.jointrivial.sourcemanager.nordigen.service.CountryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class NordigenController {

    private final CountryService countryService;
    private final BankService bankService;

    public NordigenController(CountryService countryService, BankService bankService) {
        this.countryService = countryService;
        this.bankService = bankService;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value = "/nordigen_countries", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CountryViewModel>> getAvailableCountries() {

        List<CountryViewModel> countries = countryService.getAllAvailableCountries();

        return new ResponseEntity<>(countries, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value = "/banks/{countryCode}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<BankViewModel>> getAvailableBanks(@PathVariable(name = "countryCode") String country) throws InterruptedException, IOException, URISyntaxException {
        List<BankViewModel> bankViewModels = this.bankService.getAllBankIDsAndNamesForCountry(country);

        // TODO add exc handler

        return new ResponseEntity<>(bankViewModels, HttpStatus.OK);
    }
}
