package com.bikerent.application.services;

import com.bikerent.application.domains.TokenDomain;
import com.bikerent.application.ports.outbound.TokenOutboundPort;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

public class TokenService {

    private final TokenOutboundPort tokenOutboundPort;

    public TokenService(TokenOutboundPort tokenOutboundPort) {
        this.tokenOutboundPort = tokenOutboundPort;
    }

    public TokenDomain createAccessToken(String owner) {
        TokenDomain tokenDomain = new TokenDomain();
        tokenDomain.setToken(UUID.randomUUID());
        tokenDomain.setExpiration(System.currentTimeMillis() + 120000);
        tokenDomain.setOwner(owner);
        tokenDomain.setCreatedAt(LocalDate.now());
        return tokenDomain;
    }

    public String addToken(TokenDomain tokenDomain) {
        return tokenOutboundPort.addToken(tokenDomain);
    }

    public TokenDomain getTokenByOwner(String owner) {
        return tokenOutboundPort.getTokenByOwner(owner);
    }

    public void removeToken(String id) {
        tokenOutboundPort.removeToken(id);
    }

    public boolean isValidToken(UUID token) {
        TokenDomain tokenDomain = tokenOutboundPort.getToken(token);

        if (Objects.isNull(tokenDomain)) {
            return false;
        }

        return tokenDomain.getExpiration() > System.currentTimeMillis();
    }

}
