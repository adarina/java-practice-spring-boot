package com.ada.javapracticespringboot.user.validation;

import com.ada.javapracticespringboot.user.model.User;
import org.apache.commons.lang3.StringUtils;

import java.util.regex.Pattern;

public class SurnameUserValidator extends UserValidator {
    private static final Pattern SURNAME_PATTERN = Pattern.compile("[A-Za-z]+");

    @Override
    public boolean check(User user) {
        if (StringUtils.isBlank(user.getSurname()) || !SURNAME_PATTERN.matcher(user.getSurname()).matches()) {
            return false;
        }
        return checkNext(user);
    }

}