package com.bikerent.entities;

import com.bikerent.application.domains.User;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document
public class UserEntity {

    @Id
    private String id;

    private String name;

    private String email;

    private String password;

    private LocalDate createdAt;

    public UserEntity(User user) {
        id = user.getId();
        name = user.getName();
        email = user.getEmail();
        password = user.getPassword();
        createdAt = user.getCreatedAt();
    }

}
