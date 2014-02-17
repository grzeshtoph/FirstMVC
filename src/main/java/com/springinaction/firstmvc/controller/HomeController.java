package com.springinaction.firstmvc.controller;

import com.springinaction.firstmvc.service.PhoneService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.inject.Inject;
import java.util.Map;

/**
 * MVC controller for displaying home page.
 */
@Controller
public class HomeController {
    private final PhoneService phoneService;

    @Inject
    public HomeController(PhoneService phoneService) {
        this.phoneService = phoneService;
    }

    @RequestMapping({"/", "/home"})
    public String showHomePage(Model model) {
        model.addAttribute("greeting", "Welcome to the Phone Catalog");
        model.addAttribute(phoneService.getPhones());
        model.addAttribute("pageActive", "home");
        return "home";
    }
}
