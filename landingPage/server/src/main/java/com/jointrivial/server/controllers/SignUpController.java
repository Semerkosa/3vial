package com.jointrivial.server.controllers;

import com.jointrivial.server.models.binding.DataBindingModel;
import com.jointrivial.server.models.binding.SurveyBindingModel;
import com.jointrivial.server.services.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SignUpController {
    private final DataService dataService;

    @Autowired
    public SignUpController(DataService dataService) {
        this.dataService = dataService;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping(value = "/survey_result", consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.TEXT_PLAIN_VALUE})
    public ResponseEntity<String> getSurveyResult(@RequestBody SurveyBindingModel surveyBindingModel) {
        try {
            dataService.addSurvey(surveyBindingModel);
            return new ResponseEntity<>("Success!", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping(value = "/sign_up", consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.TEXT_PLAIN_VALUE})
    public ResponseEntity<String> signUp(@RequestBody DataBindingModel dataBindingModel) {
        try {
            dataService.createData(dataBindingModel);
            return new ResponseEntity<>("Success!", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/get_all/{page}")
    public String getAllData(@PathVariable int page) {
        return this.dataService.getAllData(page);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value = "/count")
    public long getCount() {
        return this.dataService.count();
    }
}
