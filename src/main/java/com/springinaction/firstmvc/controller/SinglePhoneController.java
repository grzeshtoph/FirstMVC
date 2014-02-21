package com.springinaction.firstmvc.controller;

import com.springinaction.firstmvc.model.persistence.Phone;
import com.springinaction.firstmvc.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * MVC controller for displaying a phone details.
 */
@RequestMapping("/phone")
@Controller
public class SinglePhoneController {
    @Autowired
    private PhoneService phoneService;

    @RequestMapping(value = "/details/{phoneId}", method = GET)
    public String getDetailsForPathVariable(@PathVariable String phoneId, Model model) {
        Phone phone = phoneService.getPhone(phoneId);
        model.addAttribute(phone);
        return "phone/details";
    }

    @RequestMapping(value = "/new", method = GET)
    public String createOpenForm(Model model) {
        model.addAttribute(new Phone());
        model.addAttribute("pageActive", "new");
        return "phone/new";
    }

    @RequestMapping(value = "/new", method = POST)
    public String create(@Valid Phone phone, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("idHasValueErrors", bindingResult.getFieldErrorCount("id") > 0);
            model.addAttribute("nameHasValueErrors", bindingResult.getFieldErrorCount("name") > 0);
            model.addAttribute("priceHasValueErrors", bindingResult.getFieldErrorCount("price") > 0);
            model.addAttribute("opinionHasValueErrors", bindingResult.getFieldErrorCount("opinion") > 0);
            model.addAttribute("pageActive", "new");
            return "phone/new";
        }

        phoneService.createNew(phone);

        return "redirect:/phone/details/" + phone.getId();
    }
}
