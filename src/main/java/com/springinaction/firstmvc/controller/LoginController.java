package com.springinaction.firstmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * MVC controller for logging in.
 */
@Controller
public class LoginController {
    @RequestMapping(value = "/login")
    public String showLoginPage(Model model) {
        return "login";
    }
}
