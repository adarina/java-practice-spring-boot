package com.ada.javapracticespringboot.user.service;

import com.ada.javapracticespringboot.user.model.User;
import com.ada.javapracticespringboot.user.repository.UserRepository;
import com.ada.javapracticespringboot.user.validation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    private final UserValidator userValidator;
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
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

    public User createUser(User user) {
        if (!validateUser(user)) {
            throw new IllegalArgumentException("User validation failed");
        }
        return userRepository.save(user);
    }

    public User getUser(Long id) {
        return userRepository.findById(id);
    }

    public Map<Long, User> getAllUsers() {
        return userRepository.findAll();
    }
}
