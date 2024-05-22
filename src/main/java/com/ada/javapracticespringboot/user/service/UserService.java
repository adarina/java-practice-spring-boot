package com.ada.javapracticespringboot.user.service;

import com.ada.javapracticespringboot.user.model.User;
import com.ada.javapracticespringboot.user.validation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    private final UserValidator userValidator;

    public UserService() {
        userValidator = UserValidator.link(
                new EmailUserValidator(),
                new NameUserValidator(),
                new PasswordUserValidator(),
                new PhoneUserValidator(),
                new SurnameUserValidator()
        );
    }

    public boolean validateUser(User user) {
        boolean isValid = userValidator.check(user);
        if (!isValid) {
            logger.error("User validation failed: {}", user);
        }
        return isValid;
    }
}
