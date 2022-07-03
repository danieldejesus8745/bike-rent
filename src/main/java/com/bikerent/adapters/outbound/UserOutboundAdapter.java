package com.bikerent.adapters.outbound;

import com.bikerent.application.domains.User;
import com.bikerent.application.ports.outbound.UserOutboundPort;
import com.bikerent.entities.UserEntity;
import com.bikerent.mappers.UserMapper;
import com.bikerent.repositories.UserEntityRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static com.bikerent.utils.Messages.MESSAGE_2;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserOutboundAdapter implements UserOutboundPort {

    private final UserEntityRepository userEntityRepository;
    private final UserMapper userMapper;

    @Override
    public void addUser(User user) {
        try {
            userEntityRepository.save(new UserEntity(user));
        } catch (RuntimeException runtimeException) {
            log.error("O cadastro não pôde ser concluído por causa do seguinte erro: . " + runtimeException.getMessage());
            throw new IllegalStateException(MESSAGE_2.getDescription());
        }
    }

    @Override
    public User getUser(String email) {
        UserEntity userEntity = userEntityRepository.findByEmail(email).orElse(null);

        if (Objects.isNull(userEntity)) {
            return null;
        }

        return userMapper.fromUserEntityToUser(userEntity);
    }

}
