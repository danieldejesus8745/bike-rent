package com.bikerent.application.services;

import com.bikerent.application.domains.User;
import com.bikerent.application.ports.outbound.UserOutboundPort;

import java.time.LocalDate;

public class UserService {

    private final UserOutboundPort userOutboundPort;

    public UserService(UserOutboundPort userOutboundPort) {
        this.userOutboundPort = userOutboundPort;
    }

    public String addUser(User user) {
        user.setCreatedAt(LocalDate.now());
        return userOutboundPort.addUser(user);
    }

    public User getUser(String email) {
        return userOutboundPort.getUser(email);
    }

}
