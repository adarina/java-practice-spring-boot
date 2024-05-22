package com.ada.javapracticespringboot.user.validation;

import com.ada.javapracticespringboot.user.model.User;
import org.apache.commons.lang3.StringUtils;

import java.util.regex.Pattern;

public class NameUserValidator extends UserValidator {

    private static final Pattern NAME_PATTERN = Pattern.compile("[A-Za-z]+");

    @Override
    public boolean check(User user) {
        if (StringUtils.isBlank(user.getName()) || !NAME_PATTERN.matcher(user.getName()).matches()) {
            return false;
        }
        return checkNext(user);
    }
}
