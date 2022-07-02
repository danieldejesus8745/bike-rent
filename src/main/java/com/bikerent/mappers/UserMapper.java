package com.bikerent.mappers;

import com.bikerent.application.domains.User;
import com.bikerent.dto.UserDTO;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {

    public User toUser(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setCreatedAt(userDTO.getCreatedAt());
        return user;
    }

}
