package com.example.mockdataprovider.service;

import com.example.mockdataprovider.models.dtos.*;
import com.google.gson.*;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.*;

@Service
public class BalanceServiceImpl implements BalanceService {

    private static final String BALANCES_PATH = "MockDataProvider/src/main/resources/files/balances.json";

    @Override
    public String readJsonFile() throws IOException {
        return String.join("", Files.readAllLines(Path.of(BALANCES_PATH)));
    }

    @Override
    public UserBalancesRootDto getAllBalances() throws IOException {
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();

        return gson.fromJson(readJsonFile(), UserBalancesRootDto.class);
    }
}
