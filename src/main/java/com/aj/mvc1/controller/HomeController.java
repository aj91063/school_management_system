package com.aj.mvc1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Controller
public class HomeController {

    @RequestMapping(path = {"", "/", "/home"})
    public String displayHomePage(Model model) {
        model.addAttribute("username", "Abhishek jaiswal");
        return "home.html";
    }



}



