package com.jointrivial.asset.yodlee.controller;

import com.jointrivial.asset.yodlee.service.YodleeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/yodlee")
public class YodleeController {

    private final YodleeService yodleeService;

    public YodleeController(YodleeService yodleeService) {
        this.yodleeService = yodleeService;
    }

    @GetMapping("/holdings")
    public String getUserHoldings(String keyOrganizationJson) {

        //ToDo Add call to service method for retrieving the holdings per each account

        return null;
    }
}
