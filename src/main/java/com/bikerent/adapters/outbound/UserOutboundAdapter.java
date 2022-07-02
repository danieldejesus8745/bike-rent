package com.bikerent.adapters.outbound;

import com.bikerent.application.domains.User;
import com.bikerent.application.ports.outbound.UserOutboundPort;
import com.bikerent.entities.UserEntity;
import com.bikerent.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserOutboundAdapter implements UserOutboundPort {

    private final UserRepository userRepository;

    @Override
    public void addUser(User user) {
        userRepository.save(new UserEntity(user));
    }

}
