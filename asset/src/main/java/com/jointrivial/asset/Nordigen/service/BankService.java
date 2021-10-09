package com.jointrivial.asset.Nordigen.service;

import com.jointrivial.asset.Nordigen.exceptions.InvalidCountryException;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public interface BankService {
    List<String> allBanksInCountry(String country) throws IOException, URISyntaxException, InterruptedException;
}
