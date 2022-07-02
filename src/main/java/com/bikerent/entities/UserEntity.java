package com.bikerent.entities;

import com.bikerent.application.domains.User;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.UUID;

@Document
public class UserEntity {

    @Id
    private UUID uuid;

    private String name;

    private String email;

    private String password;

    private LocalDate createdAt;

    public UserEntity(User user) {
        uuid = user.getUuid();
        name = user.getName();
        email = user.getEmail();
        password = user.getPassword();
        createdAt = user.getCreatedAt();
    }

}
