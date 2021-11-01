package com.jointrivial.asset.nordigen.web;

import com.jointrivial.asset.nordigen.models.views.balances.UserBalancesViewModel;
import com.jointrivial.asset.nordigen.service.AccountService;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
@RequestMapping("/asset")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping(value = "/balances",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserBalancesViewModel> getAllAccountBalances
            (@RequestHeader("Key-Organization") String keyOrganizationJson) throws IOException, InterruptedException {

        UserBalancesViewModel accountBalances = this.accountService.getUserBalances(keyOrganizationJson);

        // TODO add exc handler

        return new ResponseEntity<>(accountBalances, HttpStatus.OK);
    }
}
