package com.jointrivial.asset.nordigen.web;

import com.jointrivial.asset.nordigen.models.views.BankViewModel;
import com.jointrivial.asset.nordigen.service.BankService;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

@Controller
@RequestMapping("/asset")
public class BankController {

    private final BankService bankService;

    public BankController(BankService bankService) {
        this.bankService = bankService;
    }

    @GetMapping(value = "/all-banks-{country}",
                produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<BankViewModel>> getAllBankIDsAndNamesForCountry(@PathVariable String country) throws IOException, URISyntaxException, InterruptedException {
        List<BankViewModel> bankViewModels = this.bankService.getAllBankIDsAndNamesForCountry(country);

        // TODO add exc handler

        return new ResponseEntity<>(bankViewModels, HttpStatus.OK);
    }
}
