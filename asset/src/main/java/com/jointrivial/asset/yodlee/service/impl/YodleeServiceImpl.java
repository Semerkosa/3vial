package com.jointrivial.asset.yodlee.service.impl;

import com.google.gson.Gson;
import com.jointrivial.asset.yodlee.api.YodleeApi;
import com.jointrivial.asset.yodlee.service.YodleeService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


@Service
public class YodleeServiceImpl implements YodleeService {

    private final YodleeApi yodleeApi;
    private final Gson gson;
    private final ModelMapper modelMapper;

    public YodleeServiceImpl(YodleeApi yodleeApi, Gson gson, ModelMapper modelMapper) {
        this.yodleeApi = yodleeApi;
        this.gson = gson;
        this.modelMapper = modelMapper;
    }

    @Override
    public String getHoldings(String keyOrganizationJson) {

        //ToDo call YodleeApi's getHoldings for each accountid from the input param
        //ToDo Add code similar to the one in getUserBalances(String keyOrganizationJson) from the nordigen service class

        return null;
    }
}
