package com.jointrivial.asset.nordigen.web;

import com.google.gson.Gson;
import com.jointrivial.asset.nordigen.service.BankService;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

@Controller
@RequestMapping("/nordigen")
public class BankController {

    private final BankService bankService;

    public BankController(BankService bankService, Gson gson) {
        this.bankService = bankService;
    }

    @GetMapping(value = "/all-banks-{country}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<String>> getAllBankNamesInCountry(@PathVariable String country) throws IOException, URISyntaxException, InterruptedException {
        List<String> bankNames = this.bankService.allBankNamesInCountry(country);

        // TODO think of a better handler
        if (bankNames == null) {
            return new ResponseEntity<>(
                    List.of("Invalid country code!"),
                    HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(bankNames, HttpStatus.OK);
    }
}
