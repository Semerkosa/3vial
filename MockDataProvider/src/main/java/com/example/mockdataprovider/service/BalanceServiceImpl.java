package com.example.mockdataprovider.service;

import com.example.mockdataprovider.models.dtos.BalanceRootDto;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class BalanceServiceImpl implements BalanceService {

    private static final String BALANCES_PATH = "src/main/resources/files/balances.json";

    @Override
    public String readJsonFile() throws IOException {
        return String.join("", Files.readAllLines(Path.of(BALANCES_PATH)));
    }

    @Override
    public BalanceRootDto getAllBalances() throws IOException {
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();

        return gson.fromJson(readJsonFile(), BalanceRootDto.class);
    }
}
