package com.jointrivial.sourcemanager.nordigen.web.controller;

import com.jointrivial.sourcemanager.nordigen.model.view.BankViewModel;
import com.jointrivial.sourcemanager.nordigen.service.BankService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/banks")
public class NordigenController {

    private final BankService bankService;

    public NordigenController(BankService bankService) {
        this.bankService = bankService;
    }

    @GetMapping(value = "/{countryCode}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<BankViewModel>> getAvailableBanks(@PathVariable(name = "countryCode") String country) throws InterruptedException, IOException, URISyntaxException {
        List<BankViewModel> bankViewModels = this.bankService.getAllBankIDsAndNamesForCountry(country);

        // TODO add exc handler

        return new ResponseEntity<>(bankViewModels, HttpStatus.OK);
    }
}
