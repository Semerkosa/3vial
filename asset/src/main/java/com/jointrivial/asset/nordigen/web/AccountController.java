package com.jointrivial.asset.nordigen.web;

import com.jointrivial.asset.nordigen.models.views.balances.UserBalancesViewModel;
import com.jointrivial.asset.nordigen.service.AccountService;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URISyntaxException;

@Controller
@RequestMapping("/asset")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping(value = "/balances",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserBalancesViewModel> getAllBankIDsAndNamesForCountry
            (@RequestHeader("Key-Organization") String organizationKeysJson) throws IOException, InterruptedException {

        UserBalancesViewModel accountBalances = this.accountService.getUserBalances(organizationKeysJson);

        // TODO add exc handler

        return new ResponseEntity<>(accountBalances, HttpStatus.OK);
    }
}
