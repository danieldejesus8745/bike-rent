package com.bikerent.mappers;

import com.bikerent.application.domains.User;
import com.bikerent.dto.UserDTO;

public class UserMapper {

    public User toUser(UserDTO userDTO) {
        User user = new User();
        user.setUuid(userDTO.getUuid());
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setCreatedAt(userDTO.getCreatedAt());
        return user;
    }

}
