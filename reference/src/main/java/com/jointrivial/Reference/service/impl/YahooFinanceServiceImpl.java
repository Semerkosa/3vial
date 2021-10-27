package com.jointrivial.Reference.service.impl;

import com.jointrivial.Reference.service.YahooFinanceService;
import com.jointrivial.Reference.service.model.YahooFinanceServiceModel;
import com.jointrivial.Reference.web.model.YahooFinanceViewModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yahoofinance.YahooFinance;

import java.io.IOException;
import java.math.BigDecimal;

@Service
public class YahooFinanceServiceImpl implements YahooFinanceService {

    private final ModelMapper modelMapper;

    @Autowired
    public YahooFinanceServiceImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }


    @Override
    public YahooFinanceViewModel findPrice(String symbol){

        try {
            return this.modelMapper.map(new YahooFinanceServiceModel(YahooFinance.get(symbol)),YahooFinanceViewModel.class);
        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;
    }


}
