package com.bikerent.application.ports.inbound;

import com.bikerent.application.domains.TokenDomain;

public interface TokenInboundPort {

    TokenDomain createToken(String owner);

    String addToken(TokenDomain tokenDomain);

    TokenDomain getTokenByOwner(String owner);

    void removeToken(String id);

}
