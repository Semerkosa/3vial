package com.jointrivial.MockTwelveData.service;

import com.jointrivial.MockTwelveData.web.model.TwelveDataStockViewModel;

public interface TestingService{

    TwelveDataStockViewModel getPriceBySymbol(String symbol);

}
