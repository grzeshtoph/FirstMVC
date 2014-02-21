package com.springinaction.firstmvc.controller;

import com.springinaction.firstmvc.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * MVC for managing list of phones.
 */
@RequestMapping("/phones")
@Controller
public class PhonesListController {
    @Autowired
    private PhoneService phoneService;

    @RequestMapping(value = "/list", method = GET)
    public String listPhones(@RequestParam(value = "name") String name, Model model) {
        model.addAttribute(phoneService.getPhones(name));
        return "phones/list";
    }
}
