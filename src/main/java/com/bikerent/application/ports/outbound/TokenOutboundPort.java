package com.bikerent.application.ports.outbound;

import com.bikerent.application.domains.TokenDomain;

import java.util.UUID;

public interface TokenOutboundPort {

    String addToken(TokenDomain tokenDomain);

    TokenDomain getTokenByOwner(String owner);

    void removeToken(String id);

    TokenDomain getToken(UUID token);

}
