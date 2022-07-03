package com.bikerent.controllers;

import com.bikerent.adapters.inbound.UserInboundAdapter;
import com.bikerent.dto.UserDTO;
import com.bikerent.mappers.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.bikerent.utils.Messages.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api/v1/users")
public class UserController {

    private final UserInboundAdapter userInboundAdapter;
    private final UserMapper userMapper;

    @PostMapping
    public ResponseEntity<String> addUser(@RequestBody UserDTO userDTO) {
        userInboundAdapter.addUser(userMapper.fromUserDtoToUser(userDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(MESSAGE_1.getDescription());
    }

    @GetMapping(path = "/login/{email}/{password}")
    public ResponseEntity<String> login(@PathVariable("email") String email,
                                        @PathVariable("password") String password) {
        String response = userInboundAdapter.login(email, password);

        if (response.equals(MESSAGE_3.getDescription())) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }

        if (response.equals(MESSAGE_4.getDescription())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
