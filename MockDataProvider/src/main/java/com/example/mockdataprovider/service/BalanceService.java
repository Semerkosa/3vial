package com.example.mockdataprovider.service;

import com.example.mockdataprovider.models.dtos.UserBalancesRootDto;

import java.io.IOException;

public interface BalanceService {

    String readJsonFile() throws IOException;
    UserBalancesRootDto getAllBalances() throws IOException;
}
