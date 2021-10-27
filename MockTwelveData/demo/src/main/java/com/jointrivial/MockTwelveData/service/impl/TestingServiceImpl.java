package com.jointrivial.MockTwelveData.service.impl;

import com.jointrivial.MockTwelveData.service.TestingService;
import com.jointrivial.MockTwelveData.web.model.TwelveDataStockViewModel;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class TestingServiceImpl implements TestingService {


    private final HashMap<String,Double> references;

    public TestingServiceImpl() {
        this.references= new HashMap<String, Double>() {{
            put("EUR", 1.95583);
            put("GBP", 2.31385);
        }};
    }

    @Override
    public TwelveDataStockViewModel getPriceBySymbol(String thicker) {

        String symbol = thicker.split("-")[0];

        return new TwelveDataStockViewModel(symbol+"-BGN",this.references.get(symbol));
    }
}
