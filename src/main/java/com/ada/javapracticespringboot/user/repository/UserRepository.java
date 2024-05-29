package com.ada.javapracticespringboot.user.repository;

import com.ada.javapracticespringboot.user.model.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserRepository {

    private final Map<Long, User> users = new HashMap<>();
    private Long userIdSequence = 0L;

    public User save(User user) {
        userIdSequence++;
        user.setId(userIdSequence);
        users.put(userIdSequence, user);
        return user;
    }

    public User findById(Long id) {
        return users.get(id);
    }

    public Map<Long, User> findAll() {
        return users;
    }
}
