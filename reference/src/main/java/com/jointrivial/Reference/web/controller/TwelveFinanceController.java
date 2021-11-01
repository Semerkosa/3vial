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


    @GetMapping("/twelve/getPrice")
    public ResponseEntity<TwelveDataStockViewModel> getPrice(@RequestParam String symbol){


        return new ResponseEntity<>(this.twelveFinanceService.getCurrentPrice(symbol),
                HttpStatus.OK);
    }

    @GetMapping("/prices")
    public ResponseEntity<ReferencesViewModel> test(@RequestHeader String currency, @RequestHeader List<String> symbols){

        ReferencesViewModel references = new ReferencesViewModel();

        for (String symbol : symbols) {

            TwelveDataStockViewModel currentPrice = this.twelveFinanceService.test(symbol, currency);
            references.addModel(currentPrice);

        }

        return new ResponseEntity<>(references, HttpStatus.OK);
    }

}
