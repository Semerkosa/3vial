package com.example.mockdataprovider.web;

import com.example.mockdataprovider.models.dtos.BalancesRootDto;
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

    public ResponseEntity<BalancesRootDto> getAllBalances(@PathVariable String id) throws IOException {
        BalancesRootDto balances = null;

        if ("123".equals(id)) {
            balances = this.balanceService.getBalances("Fibank");
        } else if ("456".equals(id)){
            balances = this.balanceService.getBalances("UniCredit Bulbank");
        }

        return new ResponseEntity<>(balances, HttpStatus.OK);
    }
}
