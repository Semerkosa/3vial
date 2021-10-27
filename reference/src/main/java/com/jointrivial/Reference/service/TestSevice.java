package com.jointrivial.Reference.service;

import com.jointrivial.Reference.web.model.TwelveDataStockViewModel;

public interface TestSevice {


    TwelveDataStockViewModel getCurrentPrice(String symbol,String currency);

}
