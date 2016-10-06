package cn.SkyShadow.basic_component.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created by Richard on 16/10/5.
 */
public class OrganizationValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
