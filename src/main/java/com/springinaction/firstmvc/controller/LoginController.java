package com.springinaction.firstmvc.controller;

import com.google.common.base.Strings;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * MVC controller for logging in.
 */
@Controller
public class LoginController {
    @RequestMapping(value = "/login")
    public String showLoginPage(Model model, @RequestParam(value = "login_error", required = false) String loginError) {
        model.addAttribute("loginError", "t".equals(loginError));
        return "login";
    }
}
