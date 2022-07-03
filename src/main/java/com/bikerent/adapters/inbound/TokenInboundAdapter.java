package com.bikerent.adapters.inbound;

import com.bikerent.application.domains.TokenDomain;
import com.bikerent.application.ports.inbound.TokenInboundPort;
import com.bikerent.application.services.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TokenInboundAdapter implements TokenInboundPort {

    private final TokenService tokenService;

    @Override
    public TokenDomain createToken(String owner) {
        return tokenService.createAccessToken(owner);
    }

    @Override
    public String addToken(TokenDomain tokenDomain) {
        return tokenService.addToken(tokenDomain);
    }

    @Override
    public TokenDomain getTokenByOwner(String owner) {
        return tokenService.getTokenByOwner(owner);
    }

    @Override
    public void removeToken(String id) {
        tokenService.removeToken(id);
    }

    @Override
    public boolean isValidToken(UUID token) {
        return tokenService.isValidToken(token);
    }

}
