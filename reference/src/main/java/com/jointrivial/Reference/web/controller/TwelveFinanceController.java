package com.jointrivial.Reference.web.controller;

import com.jointrivial.Reference.service.impl.TwelveFinanceServiceImpl;
import com.jointrivial.Reference.web.model.ReferencesViewModel;
import com.jointrivial.Reference.web.model.TwelveDataStockViewModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reference")
public class TwelveFinanceController {

    private final TwelveFinanceServiceImpl twelveFinanceService;

    @Autowired
    public TwelveFinanceController(TwelveFinanceServiceImpl polygonFinanceService) {
        this.twelveFinanceService = polygonFinanceService;
    }


    @GetMapping("/twelve/prices")
    public ResponseEntity<ReferencesViewModel> getPrice(@RequestHeader String currency, @RequestHeader List<String> currencies){


        return new ResponseEntity<>(this.twelveFinanceService.getCurrentPrice(currency,currencies),
                HttpStatus.OK);
    }



}
