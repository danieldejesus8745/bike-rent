package com.bikerent.application.services;

import com.bikerent.application.domains.User;
import com.bikerent.application.ports.outbound.UserOutboundPort;

public class UserService {

    private UserOutboundPort userOutboundPort;

    public UserService(UserOutboundPort userOutboundPort) {
        this.userOutboundPort = userOutboundPort;
    }

    public void addUser(User user) {
        userOutboundPort.addUser(user);
    }

}
