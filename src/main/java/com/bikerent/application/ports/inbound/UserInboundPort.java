package com.bikerent.application.ports.inbound;

import com.bikerent.application.domains.User;

public interface UserInboundPort {

    void addUser(User user);

}
