package com.jointrivial.asset.nordigen.service.impl;

import com.google.gson.Gson;
import com.jointrivial.asset.nordigen.api.NordigenAccountInfoAPI;
import com.jointrivial.asset.nordigen.models.services.balances.BalanceRootServiceModel;
import com.jointrivial.asset.nordigen.models.services.organizationKeys.KeyOrganizationServiceModel;
import com.jointrivial.asset.nordigen.models.services.organizationKeys.UserKeyOrganizationServiceModel;
import com.jointrivial.asset.nordigen.models.views.balances.BalanceRootViewModel;
import com.jointrivial.asset.nordigen.models.views.balances.UserBalancesViewModel;
import com.jointrivial.asset.nordigen.service.AccountService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class AccountServiceImpl implements AccountService {

    private final Gson gson;
    private final ModelMapper modelMapper;
    private final NordigenAccountInfoAPI nordigenAccountInfoAPI;

    public AccountServiceImpl(Gson gson, ModelMapper modelMapper, NordigenAccountInfoAPI nordigenAccountInfoAPI) {
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.nordigenAccountInfoAPI = nordigenAccountInfoAPI;
    }

    @Override
    public UserBalancesViewModel getUserBalances(String organizationKeysJson) throws IOException, InterruptedException {
        UserBalancesViewModel userBalances = new UserBalancesViewModel();

        final Map<String, String> organizationKeyPairs = getOrganizationKeyPairs(organizationKeysJson);

        for (Map.Entry<String, String> entry : organizationKeyPairs.entrySet()) {
            String organizationName = entry.getKey();
            String accountId = entry.getValue();

            String accountBalancesJson = nordigenAccountInfoAPI.getAccountBalances(accountId);

            // TODO handle exception properly
            if (accountBalancesJson == null) {
                return null;
            }

            BalanceRootServiceModel balanceRootServiceModel =
                    this.gson.fromJson(accountBalancesJson, BalanceRootServiceModel.class);
            BalanceRootViewModel balanceRootViewModel =
                    this.modelMapper.map(balanceRootServiceModel, BalanceRootViewModel.class);


            balanceRootViewModel.setOrganizationName(organizationName);
            userBalances.addBalances(balanceRootViewModel);
        }

        return userBalances;
    }

    private Map<String, String> getOrganizationKeyPairs(String organizationKeysJson) {
        UserKeyOrganizationServiceModel userKeyOrganizationServiceModel =
                this.gson.fromJson(organizationKeysJson, UserKeyOrganizationServiceModel.class);

        Map<String, String> map = new HashMap<>();

        // TODO: Check what is the organizationName in a base controller
        // currently working with nordigen providers only
        for (KeyOrganizationServiceModel pair : userKeyOrganizationServiceModel.getOrganizationKeys()) {
            map.put(pair.getOrganizationName(), pair.getOrganizationKey());
        }

        return map;
    }
}
