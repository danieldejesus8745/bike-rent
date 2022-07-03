package com.bikerent.adapters.outbound;

import com.bikerent.application.domains.Token;
import com.bikerent.application.ports.outbound.TokenOutboundPort;
import com.bikerent.entities.TokenEntity;
import com.bikerent.repositories.TokenEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TokenOutboundAdapter implements TokenOutboundPort {

    private final TokenEntityRepository tokenEntityRepository;

    @Override
    public String addToken(Token token) {
        token.setToken(UUID.randomUUID());
        TokenEntity addedToken = tokenEntityRepository.save(new TokenEntity(token));
        return addedToken.getToken().toString();
    }

}
