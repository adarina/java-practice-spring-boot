package com.ada.javapracticespringboot.user.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {

    private Long id;
    private String name;
    private String surname;
    private String password;
    private String email;
    private String phone;

    public User(Long id, String name, String surname, String password, String email, String phone) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.email = email;
        this.phone = phone;
    }
}