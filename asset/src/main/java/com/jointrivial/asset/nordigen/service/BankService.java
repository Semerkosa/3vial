package com.jointrivial.asset.nordigen.service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public interface BankService {
    List<String> allBankNamesInCountry(String country) throws IOException, URISyntaxException, InterruptedException;
}
