package com.jointrivial.Reference.web.controller;

import com.jointrivial.Reference.service.impl.TestServiceImpl;
import com.jointrivial.Reference.service.impl.TwelveFinanceServiceImpl;
import com.jointrivial.Reference.web.model.ReferencesViewModel;
import com.jointrivial.Reference.web.model.TwelveDataStockViewModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/reference")
public class TwelveFinanceController {

    private final TwelveFinanceServiceImpl twelveFinanceService;

    private final ModelMapper modelMapper;

    private final TestServiceImpl testService;

    @Autowired
    public TwelveFinanceController(TwelveFinanceServiceImpl polygonFinanceService, ModelMapper modelMapper, TestServiceImpl testService) {
        this.twelveFinanceService = polygonFinanceService;
        this.modelMapper = modelMapper;
        this.testService = testService;
    }


    @GetMapping("/twelve/getPrice")
    public ResponseEntity<TwelveDataStockViewModel> getPrice(@RequestParam String symbol){


        return new ResponseEntity<>(this.twelveFinanceService.getCurrentPrice(symbol),
                HttpStatus.OK);
    }

    @GetMapping("/prices")
    public ResponseEntity<ReferencesViewModel> test(@RequestParam String currency,@RequestParam List<String> symbols){

        ReferencesViewModel references = new ReferencesViewModel();

        for (String symbol : symbols) {

            TwelveDataStockViewModel currentPrice = this.testService.getCurrentPrice(symbol, currency);
            references.addModel(currentPrice);

        }

        return new ResponseEntity<>(references, HttpStatus.OK);
    }

}
