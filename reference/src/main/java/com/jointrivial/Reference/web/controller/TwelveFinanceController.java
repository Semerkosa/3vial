package com.jointrivial.Reference.web.controller;

import com.jointrivial.Reference.service.impl.TwelveFinanceServiceImpl;
import com.jointrivial.Reference.web.model.TwelveDataStockViewModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reference/twelve/")
public class TwelveFinanceController {

    private final TwelveFinanceServiceImpl twelveFinanceService;

    private final ModelMapper modelMapper;

    @Autowired
    public TwelveFinanceController(TwelveFinanceServiceImpl polygonFinanceService, ModelMapper modelMapper) {
        this.twelveFinanceService = polygonFinanceService;
        this.modelMapper = modelMapper;
    }


    @GetMapping("/getPrice")
    public ResponseEntity<TwelveDataStockViewModel> getPrice(@RequestParam String symbol){


        return new ResponseEntity<>(this.twelveFinanceService.getCurrentPrice(symbol),
                HttpStatus.OK);
    }

}
