package com.springinaction.firstmvc.controller;

import com.springinaction.firstmvc.service.PhoneService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.inject.Inject;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * MVC for managing list of phones.
 */
@RequestMapping("/phones")
@Controller
public class PhonesListController {
    private PhoneService phoneService;

    @Inject
    public PhonesListController(PhoneService phoneService) {
        this.phoneService = phoneService;
    }

    @RequestMapping(value="/list", method = GET)
    public String listPhones(@RequestParam("name") String name, Model model) {
        model.addAttribute(phoneService.getPhones(name));
        return "phones/list";
    }
}
