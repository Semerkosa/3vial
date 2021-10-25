package com.jointrivial.Reference.service;

import com.jointrivial.Reference.service.model.YahooFinanceServiceModel;
import com.jointrivial.Reference.web.model.YahooFinanceViewModel;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

public interface YahooFinanceService {

    YahooFinanceViewModel findPrice(String symbol);
}
