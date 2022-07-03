package com.bikerent.application.ports.inbound;

import com.bikerent.application.domains.TokenDomain;

import java.util.UUID;

public interface TokenInboundPort {

    TokenDomain createToken(String owner);

    String addToken(TokenDomain tokenDomain);

    TokenDomain getTokenByOwner(String owner);

    void removeToken(String id);

    boolean isValidToken(UUID token);

}
