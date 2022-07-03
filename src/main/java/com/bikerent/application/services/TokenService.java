package com.bikerent.application.services;

import com.bikerent.application.domains.Token;
import com.bikerent.application.ports.outbound.TokenOutboundPort;

import java.time.LocalDate;
import java.util.UUID;

public class TokenService {

    private final TokenOutboundPort tokenOutboundPort;

    public TokenService(TokenOutboundPort tokenOutboundPort) {
        this.tokenOutboundPort = tokenOutboundPort;
    }

    public Token createAccessToken(String owner) {
        Token token = new Token();
        token.setToken(UUID.randomUUID());
        token.setExpiration(System.currentTimeMillis() + 120000);
        token.setOwner(owner);
        token.setCreatedAt(LocalDate.now());
        return token;
    }

    public String addToken(Token token) {
        return tokenOutboundPort.addToken(token);
    }

}
