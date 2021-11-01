package com.jointrivial.MockTwelveData.web;


import com.jointrivial.MockTwelveData.service.TestingService;
import com.jointrivial.MockTwelveData.web.model.TwelveDataStockViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/twelve-data")
public class MockTwelveDataController {

    private final TestingService testingService;

    @Autowired
    public MockTwelveDataController(TestingService testingService) {
        this.testingService = testingService;
    }


    @GetMapping("/gerPrice")
    public ResponseEntity<TwelveDataStockViewModel> getPrice(@RequestParam String symbol){

        return new ResponseEntity<>( this.testingService.getPriceBySymbol(symbol), HttpStatus.OK);
    }

}
