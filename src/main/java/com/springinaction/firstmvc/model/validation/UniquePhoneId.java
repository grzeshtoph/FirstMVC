package com.springinaction.firstmvc.model.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Additional annotation for hibernate validator to enable validation of phone Id uniqueness.
 */
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniquePhoneIdValidator.class)
@Documented
public @interface UniquePhoneId {
    String message() default "{phone.validation.error.id.unique}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
