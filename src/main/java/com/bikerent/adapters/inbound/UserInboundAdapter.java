package com.bikerent.adapters.inbound;

import com.bikerent.application.domains.TokenDomain;
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
    public String addUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userService.addUser(user);
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

        TokenDomain tokenDomain = addToken(user.getEmail());

        return tokenDomain.getToken().toString();
    }

    private TokenDomain addToken(String email) {
        TokenDomain tokenDomainByOwner = tokenInboundAdapter.getTokenByOwner(email);

        if (Objects.nonNull(tokenDomainByOwner)) {
            tokenInboundAdapter.removeToken(tokenDomainByOwner.getId());
        }

        TokenDomain tokenDomain = tokenInboundAdapter.createToken(email);
        tokenInboundAdapter.addToken(tokenDomain);

        return tokenDomain;
    }

}
