package com.jointrivial.Reference.service;

import com.jointrivial.Reference.web.model.ReferencesViewModel;
import com.jointrivial.Reference.web.model.TwelveDataStockViewModel;

import java.math.BigDecimal;
import java.util.List;

public interface TwelveFinanceService {


   ReferencesViewModel getCurrentPrice(String symbol, List<String> currencies);


}
