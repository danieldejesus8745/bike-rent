package com.bikerent.dto;

import lombok.Getter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
public class UserDTO {

    private UUID uuid;
    private String name;
    private String email;
    private String password;
    private LocalDate createdAt;

}
