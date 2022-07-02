package com.bikerent.application.services;

import com.bikerent.application.domains.User;
import com.bikerent.application.ports.outbound.UserOutboundPort;

import java.time.LocalDate;

public class UserService {

    private final UserOutboundPort userOutboundPort;

    public UserService(UserOutboundPort userOutboundPort) {
        this.userOutboundPort = userOutboundPort;
    }

    public void addUser(User user) {
        user.setCreatedAt(LocalDate.now());
        userOutboundPort.addUser(user);
    }

}
