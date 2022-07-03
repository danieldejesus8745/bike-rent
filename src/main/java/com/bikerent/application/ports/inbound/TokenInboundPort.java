package com.bikerent.application.ports.inbound;

import com.bikerent.application.domains.Token;

public interface TokenInboundPort {

    Token createToken(String owner);

    String addToken(Token token);

}
