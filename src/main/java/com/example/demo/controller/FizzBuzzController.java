package com.example.demo.controller;

import com.example.demo.service.FizzBuzzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping(value = "/fizzbuzz")
public class FizzBuzzController {

    // ToDo: Apply Unit testing on FizzBuzzController Class --- DONE

    private final FizzBuzzService demoService;

    @Autowired
    public FizzBuzzController(FizzBuzzService demoService) {
        this.demoService = demoService;
    }

    @GetMapping
    public ArrayList FizzBuzz(@RequestParam(name = "start", defaultValue = "1") Integer start,
                              @RequestParam(name = "end", defaultValue = "100") Integer end) {
        return demoService.FizzBuzz(start, end);
    }
}
