package com.example.mockdataprovider.service;

import com.example.mockdataprovider.models.dtos.*;
import com.google.gson.*;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.*;

@Service
public class BalanceServiceImpl implements BalanceService {

    private static final String FIBANK_PATH = "src/main/resources/files/Fibank-balances.json";
    private static final String UNICREDIT_PATH = "src/main/resources/files/UniCredit-balances.json";

    @Override
    public String readJsonFile(String filePath) throws IOException {
        return String.join("", Files.readAllLines(Path.of(filePath)));
    }

    @Override
    public BalancesRootDto getBalances(String bankName) throws IOException {
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();

        if ("Fibank".equals(bankName)) {
            return gson.fromJson(readJsonFile(FIBANK_PATH), BalancesRootDto.class);
        }

        return gson.fromJson(readJsonFile(UNICREDIT_PATH), BalancesRootDto.class);
    }
}
