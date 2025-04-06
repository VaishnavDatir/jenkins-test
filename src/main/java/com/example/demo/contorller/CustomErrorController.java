package com.example.demo.contorller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomErrorController implements ErrorController {

    @RequestMapping("/error")
    public String handleError() {
        // Provide your custom error handling here
        return "error"; // Return a custom error page (like error.html) from the resources folder
    }

}