package com.ada.javapracticespringboot.user.validation;

import com.ada.javapracticespringboot.user.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserValidatorTest {

    private UserValidator userValidator;

    @BeforeEach
    void setUp() {
        userValidator = UserValidator.link(
                new EmailUserValidator(),
                new NameUserValidator(),
                new PasswordUserValidator(),
                new PhoneUserValidator(),
                new SurnameUserValidator()
        );
    }

    @Test
    void shouldFailWhenEmailIsNull() {
        User user = new User(1L,"Marek", "Mostowiak", "password123", null, "123456789");
        assertFalse(userValidator.check(user));
    }

    @Test
    void shouldFailWhenEmailIsEmpty() {
        User user = new User(1L,"Marek", "Mostowiak", "password123", "", "123456789");
        assertFalse(userValidator.check(user));
    }

    @Test
    void shouldFailWhenEmailIsBlank() {
        User user = new User(1L,"Marek", "Mostowiak", "password123", " ", "123456789");
        assertFalse(userValidator.check(user));
    }

    @Test
    void shouldFailWhenEmailIsInvalid() {
        User user = new User(1L,"Marek", "Mostowiak", "password123", "invalid-email", "123456789");
        assertFalse(userValidator.check(user));
    }

    @Test
    void shouldPassWhenEmailIsValid() {
        User user = new User(1L,"Marek", "Mostowiak", "password123", "marek.mostowiak@example.com", "123456789");
        assertTrue(userValidator.check(user));
    }

    @Test
    void shouldFailWhenNameIsNull() {
        User user = new User(1L,null, "Mostowiak", "password123", "marek.mostowiak@example.com", "123456789");
        assertFalse(userValidator.check(user));
    }

    @Test
    void shouldFailWhenNameIsEmpty() {
        User user = new User(1L,"", "Mostowiak", "password123", "marek.mostowiak@example.com", "123456789");
        assertFalse(userValidator.check(user));
    }

    @Test
    void shouldFailWhenNameIsBlank() {
        User user = new User(1L," ", "Mostowiak", "password123", "marek.mostowiak@example.com", "123456789");
        assertFalse(userValidator.check(user));
    }

    @Test
    void shouldFailWhenNameContainsNonAlphabeticCharacters() {
        User user = new User(1L,"Marek123", "Mostowiak", "password123", "marek.mostowiak@example.com", "123456789");
        assertFalse(userValidator.check(user));
    }

    @Test
    void shouldPassWhenNameIsValid() {
        User user = new User(1L,"Marek", "Mostowiak", "password123", "marek.mostowiak@example.com", "123456789");
        assertTrue(userValidator.check(user));
    }

    @Test
    void shouldFailWhenPasswordIsNull() {
        User user = new User(1L,"Marek", "Mostowiak", null, "marek.mostowiak@example.com", "123456789");
        assertFalse(userValidator.check(user));
    }

    @Test
    void shouldFailWhenPasswordIsEmpty() {
        User user = new User(1L,"Marek", "Mostowiak", "", "marek.mostowiak@example.com", "123456789");
        assertFalse(userValidator.check(user));
    }

    @Test
    void shouldFailWhenPasswordIsBlank() {
        User user = new User(1L,"Marek", "Mostowiak", " ", "marek.mostowiak@example.com", "123456789");
        assertFalse(userValidator.check(user));
    }

    @Test
    void shouldFailWhenPasswordIsTooShort() {
        User user = new User(1L,"Marek", "Mostowiak", "short", "marek.mostowiak@example.com", "123456789");
        assertFalse(userValidator.check(user));
    }

    @Test
    void shouldPassWhenPasswordIsValid() {
        User user = new User(1L,"Marek", "Mostowiak", "password123", "marek.mostowiak@example.com", "123456789");
        assertTrue(userValidator.check(user));
    }

    @Test
    void shouldFailWhenPhoneIsNull() {
        User user = new User(1L,"Marek", "Mostowiak", "password123", "marek.mostowiak@example.com", null);
        assertFalse(userValidator.check(user));
    }

    @Test
    void shouldFailWhenPhoneIsEmpty() {
        User user = new User(1L,"Marek", "Mostowiak", "password123", "marek.mostowiak@example.com", "");
        assertFalse(userValidator.check(user));
    }

    @Test
    void shouldFailWhenPhoneIsBlank() {
        User user = new User(1L,"Marek", "Mostowiak", "password123", "marek.mostowiak@example.com", " ");
        assertFalse(userValidator.check(user));
    }

    @Test
    void shouldFailWhenPhoneIsInvalid() {
        User user = new User(1L,"Marek", "Mostowiak", "password123", "marek.mostowiak@example.com", "12345abc");
        assertFalse(userValidator.check(user));
    }

    @Test
    void shouldPassWhenPhoneIsValid() {
        User user = new User(1L,"Marek", "Mostowiak", "password123", "marek.mostowiak@example.com", "123456789");
        assertTrue(userValidator.check(user));
    }

    @Test
    void shouldFailWhenSurnameIsNull() {
        User user = new User(1L,"Marek", null, "password123", "marek.mostowiak@example.com", "123456789");
        assertFalse(userValidator.check(user));
    }

    @Test
    void shouldFailWhenSurnameIsEmpty() {
        User user = new User(1L,"Marek", "", "password123", "marek.mostowiak@example.com", "123456789");
        assertFalse(userValidator.check(user));
    }

    @Test
    void shouldFailWhenSurnameIsBlank() {
        User user = new User(1L,"Marek", " ", "password123", "marek.mostowiak@example.com", "123456789");
        assertFalse(userValidator.check(user));
    }

    @Test
    void shouldFailWhenSurnameContainsNonAlphabeticCharacters() {
        User user = new User(1L,"Marek", "Mostowiak123", "password123", "marek.mostowiak@example.com", "123456789");
        assertFalse(userValidator.check(user));
    }

    @Test
    void shouldPassWhenSurnameIsValid() {
        User user = new User(1L,"Marek", "Mostowiak", "password123", "marek.mostowiak@example.com", "123456789");
        assertTrue(userValidator.check(user));
    }
}
