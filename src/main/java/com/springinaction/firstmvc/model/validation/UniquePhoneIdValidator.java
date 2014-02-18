package com.springinaction.firstmvc.model.validation;

import com.springinaction.firstmvc.dao.PhoneDAO;

import javax.inject.Inject;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Validator implementation for {@link UniquePhoneId} annotation.
 */
public class UniquePhoneIdValidator implements ConstraintValidator<UniquePhoneId, String> {
    private PhoneDAO phoneDAO;

    @Inject
    public void setPhoneDAO(PhoneDAO phoneDAO) {
        this.phoneDAO = phoneDAO;
    }

    @Override
    public void initialize(UniquePhoneId constraintAnnotation) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
