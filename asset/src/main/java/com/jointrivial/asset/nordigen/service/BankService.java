package com.jointrivial.asset.nordigen.service;

import com.jointrivial.asset.nordigen.models.views.BankViewModel;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public interface BankService {
    List<BankViewModel> getAllBankIDsAndNamesForCountry(String country) throws IOException, URISyntaxException, InterruptedException;
}
