package com.example.controllerview.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/hello")
public class HelloController {
    @RequestMapping(value= "/hello_world", method= RequestMethod.GET)
    public String printHelloWorld(ModelMap modelMap) {
        // add attribute to load modelMap
        modelMap.addAttribute("message", "Hello world and Welcomd to Spring MVC!");

        // return the name of the file to be loaded
        return "hello_world";
    }
}
