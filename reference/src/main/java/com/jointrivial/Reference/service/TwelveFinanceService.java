package com.jointrivial.Reference.service;

import com.jointrivial.Reference.web.model.TwelveDataStockViewModel;

import java.math.BigDecimal;

public interface TwelveFinanceService {


   TwelveDataStockViewModel getCurrentPrice(String symbol);
}
