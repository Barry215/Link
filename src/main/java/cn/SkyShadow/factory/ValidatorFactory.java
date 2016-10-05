package cn.SkyShadow.factory;

import cn.SkyShadow.basic_component.validator.UserValidator;

/**
 * Created by Richard on 16/10/5.
 */
public class ValidatorFactory {
    private final UserValidator userValidator;

    public ValidatorFactory(UserValidator userValidator) {
        this.userValidator = userValidator;
    }

    public UserValidator getUserValidator() {
        return userValidator;
    }
}
