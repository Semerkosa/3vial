package com.jointrivial.MockTwelveData.web;


import com.jointrivial.MockTwelveData.web.model.TwelveDataStockViewModel;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/twelve-data")
public class MockTwelveDataController {


    @GetMapping("/gerPrice")
    public ResponseEntity<TwelveDataStockViewModel> getPrice(){

        TwelveDataStockViewModel model = new TwelveDataStockViewModel("EUR-BGN",1.95583);
        return new ResponseEntity<>(model, HttpStatus.OK);
    }

}
