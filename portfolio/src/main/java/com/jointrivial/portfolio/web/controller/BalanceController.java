package com.jointrivial.portfolio.web.controller;

import com.jointrivial.portfolio.model.service.balance.UserBalancesServiceModel;
import com.jointrivial.portfolio.model.view.balance.UserBalancesViewModel;
import com.jointrivial.portfolio.service.AccountService;
import com.jointrivial.portfolio.service.AssetService;
import com.jointrivial.portfolio.service.ReferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/portfolio")
public class BalanceController {

    private final AccountService accountService;
    private final AssetService assetService;
    private final ReferenceService referenceService;

    @Autowired
    public BalanceController(AccountService accountService, AssetService assetService, ReferenceService referenceService) {
        this.accountService = accountService;
        this.assetService = assetService;
        this.referenceService = referenceService;
    }

    @CrossOrigin("http://localhost:3000")
    @GetMapping(value = "/balances", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserBalancesViewModel> getAllBalances(
            @RequestHeader(value = "User-Token") String userToken,
            @RequestParam String currency) throws IOException, InterruptedException, URISyntaxException {
        String keyOrganizations = this.accountService.getAllKeyOrganizations(userToken);
        UserBalancesServiceModel balances = this.assetService.getAllBalances(keyOrganizations);
        UserBalancesViewModel userBalancesViewModel = this.referenceService.calculateAmountInWantedCurrency(currency, balances);
        return new ResponseEntity<>(userBalancesViewModel, HttpStatus.OK);
    }

}
