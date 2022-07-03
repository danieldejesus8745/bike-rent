package com.bikerent.mappers;

import com.bikerent.application.domains.User;
import com.bikerent.dto.UserDTO;
import com.bikerent.entities.UserEntity;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {

    public User fromUserDtoToUser(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setCreatedAt(userDTO.getCreatedAt());
        return user;
    }

    public User fromUserEntityToUser(UserEntity userEntity) {
        User user = new User();
        user.setId(userEntity.getId());
        user.setName(userEntity.getName());
        user.setEmail(userEntity.getEmail());
        user.setPassword(userEntity.getPassword());
        user.setCreatedAt(userEntity.getCreatedAt());
        return user;
    }

}
