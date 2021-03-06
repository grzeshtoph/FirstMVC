package com.springinaction.firstmvc.model.validation;

import com.google.common.base.Strings;
import com.springinaction.firstmvc.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Validator implementation for {@link UniquePhoneId} annotation.
 */
public class UniquePhoneIdValidator implements ConstraintValidator<UniquePhoneId, String> {
    @Autowired
    private PhoneService phoneListService;

    @Override
    public void initialize(UniquePhoneId constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (Strings.isNullOrEmpty(value)) return true;
        return phoneListService.getPhone(value) == null;
    }
}
