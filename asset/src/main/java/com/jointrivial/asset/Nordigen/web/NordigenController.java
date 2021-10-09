package com.jointrivial.asset.Nordigen.web;

import com.google.gson.Gson;
import com.jointrivial.asset.Nordigen.service.BankService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

@Controller
@RequestMapping("/nordigen")
public class NordigenController {

    private final BankService bankService;
    private final Gson gson;

    public NordigenController(BankService bankService, Gson gson) {
        this.bankService = bankService;
        this.gson = gson;
    }

    @GetMapping("/all-banks-{country}")
    public ResponseEntity<String> getAllBanksInCountry(@PathVariable String country) throws IOException, URISyntaxException, InterruptedException {
        List<String> countries = this.bankService.allBanksInCountry(country);

        // TODO think of a better handler
        if (countries == null) {
            return new ResponseEntity<>(
                    "Invalid country!",
                    HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(
                this.gson.toJson(countries),
                HttpStatus.OK);
    }
}
