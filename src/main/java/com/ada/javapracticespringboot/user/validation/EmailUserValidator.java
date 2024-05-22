package com.ada.javapracticespringboot.user.validation;

import com.ada.javapracticespringboot.user.model.User;
import org.apache.commons.lang3.StringUtils;

import java.util.regex.Pattern;


public class EmailUserValidator extends UserValidator {

    private static final Pattern EMAIL_PATTERN = Pattern.compile("^(.+)@(.+)$");

    @Override
    public boolean check(User user) {
        if (StringUtils.isBlank(user.getEmail()) || !EMAIL_PATTERN.matcher(user.getEmail()).matches()) {
            return false;
        }
        return checkNext(user);
    }
}

