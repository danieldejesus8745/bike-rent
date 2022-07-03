package com.bikerent.application.ports.outbound;

import com.bikerent.application.domains.Token;

public interface TokenOutboundPort {

    String addToken(Token token);

}
