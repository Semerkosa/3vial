package com.jointrivial.asset.nordigen.web;

import com.jointrivial.asset.nordigen.models.views.balances.BalanceRootViewModel;
import com.jointrivial.asset.nordigen.service.AccountService;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URISyntaxException;

@Controller
@RequestMapping("/nordigen/account")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }


    @GetMapping(value = "/{accountId}/balances",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BalanceRootViewModel> getAllBankIDsAndNamesForCountry(@PathVariable String accountId) throws IOException, URISyntaxException, InterruptedException {
        BalanceRootViewModel accountBalances = this.accountService.getAccountBalances(accountId);

        // TODO add exc handler

        return new ResponseEntity<>(accountBalances, HttpStatus.OK);
    }
}
