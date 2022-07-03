package com.bikerent.application.ports.inbound;

import com.bikerent.application.domains.User;

public interface UserInboundPort {

    String addUser(User user);

    String login(String email, String password);

}
