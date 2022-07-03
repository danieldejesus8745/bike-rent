package com.bikerent.application.ports.outbound;

import com.bikerent.application.domains.User;

public interface UserOutboundPort {

    String addUser(User user);

    User getUser(String email);

}
