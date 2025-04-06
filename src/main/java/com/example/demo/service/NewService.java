package com.example.demo.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class NewService {

    @Value("${app.config.runon}")
    private String runningOn;

    public String getRunningOn() {
        return runningOn;
    }

}
