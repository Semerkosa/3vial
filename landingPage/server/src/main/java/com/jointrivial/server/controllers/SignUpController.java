package com.jointrivial.server.controllers;

import com.jointrivial.server.models.binding.BindingModel;
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
    @PostMapping(value = "/sign_up", consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.TEXT_PLAIN_VALUE})
    public ResponseEntity<String> signUp(@RequestBody BindingModel bindingModel) {
        boolean created = dataService.create(bindingModel);
        if (created) {
            return new ResponseEntity<>("Success!", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Error", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/get_all")
    public String getAllData() {
        return this.dataService.getAllData();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value = "/count")
    public long getCount() {
        return this.dataService.count();
    }


}