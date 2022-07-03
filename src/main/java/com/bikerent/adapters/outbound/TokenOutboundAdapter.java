package com.bikerent.adapters.outbound;

import com.bikerent.application.domains.TokenDomain;
import com.bikerent.application.ports.outbound.TokenOutboundPort;
import com.bikerent.entities.TokenEntity;
import com.bikerent.mappers.TokenMapper;
import com.bikerent.repositories.TokenEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TokenOutboundAdapter implements TokenOutboundPort {

    private final TokenEntityRepository tokenEntityRepository;
    private final TokenMapper tokenMapper;

    @Override
    public String addToken(TokenDomain tokenDomain) {
        tokenDomain.setToken(UUID.randomUUID());
        TokenEntity addedToken = tokenEntityRepository.save(new TokenEntity(tokenDomain));
        return addedToken.getToken().toString();
    }

    @Override
    public TokenDomain getTokenByOwner(String owner) {
        TokenEntity tokenEntity = tokenEntityRepository.findByOwner(owner).orElse(null);

        if (Objects.isNull(tokenEntity)) {
            return null;
        }

        return tokenMapper.fromTokenEntityToToken(tokenEntity);
    }

    @Override
    public void removeToken(String id) {
        tokenEntityRepository.deleteById(id);
    }

    @Override
    public TokenDomain getToken(UUID token) {
        TokenEntity tokenEntity = tokenEntityRepository.findByToken(token).orElse(null);

        if (Objects.isNull(tokenEntity)) {
            return null;
        }

        return tokenMapper.fromTokenEntityToToken(tokenEntity);
    }

}
