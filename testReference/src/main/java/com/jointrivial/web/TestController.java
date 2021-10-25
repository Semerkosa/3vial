package com.jointrivial.web;

import com.google.gson.Gson;
import com.jointrivial.web.model.TestStockViewModel;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController()
@RequestMapping("/reference/twelve")
public class TestController {


    @GetMapping("/getPrice")
    public ResponseEntity<Object> getPrice(){

        return new ResponseEntity<>(new TestStockViewModel("AAPL",new BigDecimal("132.00")),
                HttpStatus.OK);
    }

}
