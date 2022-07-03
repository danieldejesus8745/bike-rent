package com.bikerent.adapters.inbound;

import com.bikerent.application.domains.Token;
import com.bikerent.application.ports.inbound.TokenInboundPort;
import com.bikerent.application.services.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TokenInboundAdapter implements TokenInboundPort {

    private final TokenService tokenService;

    @Override
    public Token createToken(String owner) {
        return tokenService.createAccessToken(owner);
    }

    @Override
    public String addToken(Token token) {
        return tokenService.addToken(token);
    }

}
