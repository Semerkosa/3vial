package com.example.mockdataprovider.service;

import com.example.mockdataprovider.models.dtos.BalancesRootDto;

import java.io.IOException;

public interface BalanceService {

    String readJsonFile(String filePath) throws IOException;

    BalancesRootDto getBalances(String bankName) throws IOException;
}
