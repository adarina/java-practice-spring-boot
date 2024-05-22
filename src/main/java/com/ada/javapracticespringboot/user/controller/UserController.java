package com.ada.javapracticespringboot.user.controller;

import com.ada.javapracticespringboot.user.model.User;
import com.ada.javapracticespringboot.user.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final Map<Long, User> users = new HashMap<>();
    private Long userIdSequence = 0L;
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public Object createUser(@RequestBody User user) {
        if (!userService.validateUser(user)) {
            return ResponseEntity.badRequest().body("User validation failed");
        }
        userIdSequence++;
        user.setId(userIdSequence);
        users.put(userIdSequence, user);
        return user;
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return users.get(id);
    }

    @GetMapping
    public Map<Long, User> getAllUsers() {
        return users;
    }
}
