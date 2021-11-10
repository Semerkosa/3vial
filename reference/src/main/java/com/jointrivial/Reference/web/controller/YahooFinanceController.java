package com.jointrivial.Reference.web.controller;

import com.jointrivial.Reference.service.impl.YahooFinanceServiceImpl;
import com.jointrivial.Reference.web.model.YahooFinanceViewModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reference/yahoo")
public class YahooFinanceController {

    private final YahooFinanceServiceImpl yahooFinanceService;

    private final ModelMapper modelMapper;

    @Autowired
    public YahooFinanceController(YahooFinanceServiceImpl yahooFinanceService, ModelMapper modelMapper) {
        this.yahooFinanceService = yahooFinanceService;
        this.modelMapper = modelMapper;
    }


    @GetMapping("/price")
    public ResponseEntity<YahooFinanceViewModel> getPriceOfStock(@RequestParam String symbol){

        //TODO
        //The problem, is related with throttling. Reducing requests to <5it/s makes it work.

        return new ResponseEntity<>(this.modelMapper.map(yahooFinanceService.findPrice(symbol),YahooFinanceViewModel.class),
                HttpStatus.OK);
    }
}
