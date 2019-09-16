package com.sofyntelligen.school.control.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test/status")
public class TestController {

    @GetMapping("/")
    public String getTestStatus(){
        return "Test API Status";
    }

}
