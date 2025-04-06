package com.example.demo.contorller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.NewService;

@RestController
@RequestMapping("/api")
public class Controller {

    @Autowired
    private NewService newService;

    @GetMapping("/runningOn")
    public String getRunningOString() {
        return newService.getRunningOn();
    }

}
