package com.ada.javapracticespringboot.user.validation;

import com.ada.javapracticespringboot.user.model.User;
import org.apache.commons.lang3.StringUtils;

import java.util.regex.Pattern;

public class PhoneUserValidator extends UserValidator {
    private static final Pattern PHONE_PATTERN = Pattern.compile("\\d{9}");

    @Override
    public boolean check(User user) {
        if (StringUtils.isBlank(user.getPhone()) || !PHONE_PATTERN.matcher(user.getPhone()).matches()) {
            return false;
        }
        return checkNext(user);
    }
}
