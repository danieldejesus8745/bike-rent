package com.bikerent.adapters.outbound;

import com.bikerent.application.domains.User;
import com.bikerent.application.ports.outbound.UserOutboundPort;
import com.bikerent.entities.UserEntity;
import com.bikerent.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static com.bikerent.utils.Messages.MESSAGE_2;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserOutboundAdapter implements UserOutboundPort {

    private final UserRepository userRepository;

    @Override
    public void addUser(User user) {
        try {
            userRepository.save(new UserEntity(user));
        } catch (RuntimeException runtimeException) {
            log.error("O cadastro não pôde ser concluído por causa do seguinte erro: . " + runtimeException.getMessage());
            throw new IllegalStateException(MESSAGE_2.getDescription());
        }
    }

}
