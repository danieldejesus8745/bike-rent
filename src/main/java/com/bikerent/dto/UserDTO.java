package com.bikerent.dto;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class UserDTO {

    private String id;
    private String name;
    private String email;
    private String password;
    private LocalDate createdAt;

}
