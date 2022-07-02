package com.bikerent.adapters.inbound;

import com.bikerent.application.domains.User;
import com.bikerent.application.ports.inbound.UserInboundPort;
import com.bikerent.application.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserInboundAdapter implements UserInboundPort {

    private final UserService userService;

    @Override
    public void addUser(User user) {
        userService.addUser(user);
    }

}
