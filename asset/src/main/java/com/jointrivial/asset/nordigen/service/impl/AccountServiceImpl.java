package com.jointrivial.asset.nordigen.service.impl;

import com.google.gson.Gson;
import com.jointrivial.asset.nordigen.api.NordigenAccountInfoAPI;
import com.jointrivial.asset.nordigen.models.services.balances.BalanceRootServiceModel;
import com.jointrivial.asset.nordigen.models.views.balances.BalanceRootViewModel;
import com.jointrivial.asset.nordigen.service.AccountService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;

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
    public BalanceRootViewModel getAccountBalances(String accountId) throws IOException, InterruptedException {
        String accountBalancesJson = nordigenAccountInfoAPI.getAccountBalances(accountId);

        // TODO handle exception properly
        if (accountBalancesJson == null) {
            return null;
        }

        BalanceRootServiceModel balanceRootServiceModel =
                this.gson.fromJson(accountBalancesJson, BalanceRootServiceModel.class);

        return this.modelMapper.map(balanceRootServiceModel, BalanceRootViewModel.class);
    }
}
