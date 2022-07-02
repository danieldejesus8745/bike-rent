package com.bikerent.controllers;

import com.bikerent.adapters.inbound.UserInboundAdapter;
import com.bikerent.dto.UserDTO;
import com.bikerent.mappers.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.bikerent.utils.Messages.MESSAGE_1;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api/v1/users")
public class UserController {

    private final UserInboundAdapter userInboundAdapter;
    private final UserMapper userMapper;

    @PostMapping
    public ResponseEntity<String> addUser(@RequestBody UserDTO userDTO) {
        userInboundAdapter.addUser(userMapper.toUser(userDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(MESSAGE_1.getDescription());
    }

}
