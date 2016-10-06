package cn.SkyShadow.basic_component.validator;

import cn.SkyShadow.model.User;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class UserValidator implements Validator{
    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors,"userId","userId传入为空");
        ValidationUtils.rejectIfEmpty(errors,"username","username传入为空");
        ValidationUtils.rejectIfEmpty(errors,"password","password传入为空");
        ValidationUtils.rejectIfEmpty(errors,"phone","phone传入为空");
    }
}
