package com.jointrivial.server.controllers;

import com.jointrivial.server.services.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/home")
public class AdminController {
    private final DataService dataService;

    @Autowired
    public AdminController(DataService dataService) {
        this.dataService = dataService;
    }

    @GetMapping()
    public String homepage(Model model) {
        model.addAttribute("count", dataService.getActualCountOfUsers());
        model.addAttribute("chartData_1", getChartData_1());
        model.addAttribute("chartData_2", getChartData_2());
        model.addAttribute("answers_3", dataService.getQuestion3Statistics());
        return "homepage";
    }

    private List<List<Object>> getChartData_1() {
        return List.of(
                List.of("Seeing all my investment accounts in one place", dataService.getQuestion1Statistics("0")),
                List.of("Setting clear and meaningful financial goals", dataService.getQuestion1Statistics("1")),
                List.of("Making better investment decisions", dataService.getQuestion1Statistics("2")),
                List.of("Getting my taxes in order", dataService.getQuestion1Statistics("3")),
                List.of("Other", dataService.getQuestion1Statistics("4"))
        );
    }

    private List<List<Object>> getChartData_2() {
        return List.of(
                List.of("Nothing", dataService.getQuestion2Statistics("0")),
                List.of("Spreadsheets", dataService.getQuestion2Statistics("1")),
                List.of("I’ve set up my own APIs", dataService.getQuestion2Statistics("2")),
                List.of("Financial advisor", dataService.getQuestion2Statistics("3")),
                List.of("Dedicated software", dataService.getQuestion2Statistics("4"))
        );
    }
}
