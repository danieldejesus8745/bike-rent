package com.bikerent.application.ports.outbound;

import com.bikerent.application.domains.TokenDomain;

public interface TokenOutboundPort {

    String addToken(TokenDomain tokenDomain);

    TokenDomain getTokenByOwner(String owner);

    void removeToken(String id);

}
