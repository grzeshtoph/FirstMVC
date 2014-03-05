package com.springinaction.firstmvc.controller;

import com.springinaction.firstmvc.exception.ImageUploadException;
import com.springinaction.firstmvc.model.persistence.Phone;
import com.springinaction.firstmvc.model.validation.FormatChecks;
import com.springinaction.firstmvc.model.validation.NewPhoneChecks;
import com.springinaction.firstmvc.service.PhoneService;
import org.apache.commons.lang3.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.validation.groups.Default;

import java.util.Locale;

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
    @Autowired
    private MessageSource messageSource;
    @Autowired
    private LocaleResolver localeResolver;

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
    public String create(@Validated({Default.class, FormatChecks.class, NewPhoneChecks.class}) Phone phone,
                         BindingResult bindingResult,
                         HttpServletRequest request,
                         @RequestParam(value = "image", required = false) MultipartFile image,
                         Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("idHasValueErrors", bindingResult.getFieldErrorCount("id") > 0);
            model.addAttribute("nameHasValueErrors", bindingResult.getFieldErrorCount("name") > 0);
            model.addAttribute("priceHasValueErrors", bindingResult.getFieldErrorCount("price") > 0);
            model.addAttribute("opinionHasValueErrors", bindingResult.getFieldErrorCount("opinion") > 0);
            model.addAttribute("pageActive", "new");
            return "phone/new";
        }

        if (!image.isEmpty()) {
            try {
                validateImage(image, request);
            } catch (ImageUploadException e) {
                bindingResult.reject(e.getMessage());
                return "phone/new";
            }
        }

        escapeHtml(phone);

        phoneService.createNew(phone);

        return "redirect:/phone/details/" + phone.getId();
    }

    @RequestMapping(value = "/edit/{phoneId}", method = GET)
    public String editOpenForm(@PathVariable String phoneId, Model model) {
        Phone phone = phoneService.getPhone(phoneId);

        unescapeHtml(phone);

        model.addAttribute(phone);
        return "phone/edit";
    }

    @RequestMapping(value = "/edit", method = POST)
    public String edit(@Validated({Default.class, FormatChecks.class}) Phone phone, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("idHasValueErrors", bindingResult.getFieldErrorCount("id") > 0);
            model.addAttribute("nameHasValueErrors", bindingResult.getFieldErrorCount("name") > 0);
            model.addAttribute("priceHasValueErrors", bindingResult.getFieldErrorCount("price") > 0);
            model.addAttribute("opinionHasValueErrors", bindingResult.getFieldErrorCount("opinion") > 0);
            return "phone/edit";
        }

        escapeHtml(phone);

        phoneService.updatePhone(phone);

        return "redirect:/phone/details/" + phone.getId();
    }

    private void escapeHtml(Phone phone) {
        phone.setName(StringEscapeUtils.escapeHtml4(phone.getName()));
        phone.setOpinion(StringEscapeUtils.escapeHtml4(phone.getOpinion()));
    }

    private void unescapeHtml(Phone phone) {
        phone.setName(StringEscapeUtils.unescapeHtml4(phone.getName()));
        phone.setOpinion(StringEscapeUtils.unescapeHtml4(phone.getOpinion()));
    }

    private void validateImage(MultipartFile image, HttpServletRequest request) throws ImageUploadException {
        if (!image.getContentType().equals("image.jpeg"))
            throw new ImageUploadException(
//                    messageSource.getMessage("phone.validation.error.picture.format", null,
//                    localeResolver.resolveLocale(request))
                    "phone.validation.error.picture.format"
            );
    }
}
