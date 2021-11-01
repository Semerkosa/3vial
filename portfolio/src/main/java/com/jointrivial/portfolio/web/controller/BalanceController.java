package com.jointrivial.portfolio.web.controller;

import com.jointrivial.portfolio.model.service.balance.UserBalancesServiceModel;
import com.jointrivial.portfolio.model.view.balance.UserBalancesViewModel;
import com.jointrivial.portfolio.service.AccountService;
import com.jointrivial.portfolio.service.AssetService;
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

    public BalanceController(AccountService accountService, AssetService assetService) {
        this.accountService = accountService;
        this.assetService = assetService;
    }

    @CrossOrigin("http://localhost:3000")
    @GetMapping(value = "/balances", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserBalancesViewModel> getAllBalances(
            @RequestHeader(value = "User-Token") String userToken,
            @RequestParam String currency) throws IOException, InterruptedException, URISyntaxException {

        String keyOrganizations = this.accountService.getAllKeyOrganizations(userToken);

        UserBalancesServiceModel balances = this.assetService.getAllBalances(keyOrganizations);

        //ToDo: make a connection to reference microservice, return UserBalancesViewModel
        // and replace the bellow "new UserBalancesViewModel()" with it

        return new ResponseEntity<>(new UserBalancesViewModel(), HttpStatus.OK);
    }
}
