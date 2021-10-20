package com.example.mockdataprovider.web;

import com.example.mockdataprovider.models.dtos.BalanceRootDto;
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

    @GetMapping(value = "/api/accounts/123/balances/",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BalanceRootDto> getAllBalances() throws IOException {
        BalanceRootDto balances = this.balanceService.getAllBalances();

        return new ResponseEntity<>(balances, HttpStatus.OK);
    }
}
