package com.example.mockdataprovider.service;

import com.example.mockdataprovider.models.dtos.BalanceRootDto;

import java.io.IOException;

public interface BalanceService {

    String readJsonFile() throws IOException;
    BalanceRootDto getAllBalances() throws IOException;
}
