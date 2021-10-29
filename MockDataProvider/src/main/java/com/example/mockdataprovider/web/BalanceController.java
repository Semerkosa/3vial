package com.example.mockdataprovider.web;

import com.example.mockdataprovider.models.dtos.UserBalancesRootDto;
import com.example.mockdataprovider.service.BalanceService;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
public class BalanceController {

    private final BalanceService balanceService;

    public BalanceController(BalanceService balanceService) {
        this.balanceService = balanceService;
    }

    @GetMapping(value = "/api/accounts/{id}/balances/",
            produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<UserBalancesRootDto> getAllBalances(@PathVariable String id) throws IOException {
        UserBalancesRootDto balances = this.balanceService.getAllBalances();

        return new ResponseEntity<>(balances, HttpStatus.OK);
    }
}
