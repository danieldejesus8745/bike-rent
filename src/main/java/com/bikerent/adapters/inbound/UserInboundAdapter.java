package com.bikerent.adapters.inbound;

import com.bikerent.application.domains.Token;
import com.bikerent.application.domains.User;
import com.bikerent.application.ports.inbound.UserInboundPort;
import com.bikerent.application.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static com.bikerent.utils.Messages.MESSAGE_3;
import static com.bikerent.utils.Messages.MESSAGE_4;

@Service
@RequiredArgsConstructor
public class UserInboundAdapter implements UserInboundPort {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final TokenInboundAdapter tokenInboundAdapter;

    @Override
    public void addUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.addUser(user);
    }

    @Override
    public String login(String email, String password) {
        User user = userService.getUser(email);

        if (Objects.isNull(user)) {
            return MESSAGE_3.getDescription();
        }

        if (!passwordEncoder.matches(password, user.getPassword())) {
            return MESSAGE_4.getDescription();
        }

        Token token = tokenInboundAdapter.createToken(user.getEmail());
        tokenInboundAdapter.addToken(token);

        return token.getToken().toString();
    }

}
