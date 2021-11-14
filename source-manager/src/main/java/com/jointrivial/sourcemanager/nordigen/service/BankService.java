package com.jointrivial.sourcemanager.nordigen.service;

import com.jointrivial.sourcemanager.nordigen.model.view.BankViewModel;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public interface BankService {
    List<BankViewModel> getAllBankIDsAndNamesForCountry(String country) throws IOException, URISyntaxException, InterruptedException;
}
