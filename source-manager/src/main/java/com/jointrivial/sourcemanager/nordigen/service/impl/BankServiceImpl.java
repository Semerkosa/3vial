package com.jointrivial.sourcemanager.nordigen.service.impl;

import com.google.gson.Gson;
import com.jointrivial.sourcemanager.nordigen.api.NordigenSourceLinkAPI;
import com.jointrivial.sourcemanager.nordigen.model.service.BankServiceModel;
import com.jointrivial.sourcemanager.nordigen.model.view.BankViewModel;
import com.jointrivial.sourcemanager.nordigen.service.BankService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BankServiceImpl implements BankService {
    private final Gson gson;
    private final NordigenSourceLinkAPI nordigenSourceLinkAPI;

    public BankServiceImpl(Gson gson, NordigenSourceLinkAPI nordigenSourceLinkAPI) {
        this.gson = gson;
        this.nordigenSourceLinkAPI = nordigenSourceLinkAPI;
    }

    @Override
    public List<BankViewModel> getAllBankIDsAndNamesForCountry(String country) throws IOException, URISyntaxException, InterruptedException{
        String banksJson = nordigenSourceLinkAPI.getAllBanksForCountry(country);

        // TODO handle exception properly
        if (banksJson == null) {
            return null;
        }

        BankServiceModel[] bankServiceModels = this.gson.fromJson(banksJson, BankServiceModel[].class);

        // TODO also return logo link

        return Arrays.stream(bankServiceModels)
                .map(bsm -> new BankViewModel(bsm.getId(), bsm.getName(), bsm.getLogo()))
                .collect(Collectors.toList());
    }
}
