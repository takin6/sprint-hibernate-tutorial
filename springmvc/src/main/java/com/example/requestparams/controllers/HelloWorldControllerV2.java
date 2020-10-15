package com.example.requestparams.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/hello")
public class HelloWorldControllerV2 {
    @RequestMapping("/processFormVersionThree")
    // Model: empty object
    public String processFormVersionThree(@RequestParam("studentName") String theName, Model model) {
        theName = theName.toUpperCase();

        String result = "Hey My Friend from v3! " + theName;

        model.addAttribute("message", result);

        return "helloworld";
    }
}
