package com.springinaction.firstmvc.controller;

import com.springinaction.firstmvc.service.PhoneListService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.inject.Inject;
import java.util.Map;

/**
 * MVC controller for displaying home page.
 */
@Controller
public class HomeController {
    private PhoneListService phoneListService;

    @Inject
    public HomeController(PhoneListService phoneListService) {
        this.phoneListService = phoneListService;
    }

    @RequestMapping({"/", "/home"})
    public String showHomePage(Map<String, Object> model) {
        model.put("greeting", "Hello to the Phone Catalog!");
        model.put("phones", phoneListService.getPhones());
        return "home";
    }
}
