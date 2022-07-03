package com.bikerent.mappers;

import com.bikerent.application.domains.TokenDomain;
import com.bikerent.entities.TokenEntity;
import org.springframework.stereotype.Service;

@Service
public class TokenMapper {

    public TokenDomain fromTokenEntityToToken(TokenEntity tokenEntity) {
        TokenDomain tokenDomain = new TokenDomain();
        tokenDomain.setId(tokenEntity.getId());
        tokenDomain.setToken(tokenEntity.getToken());
        tokenDomain.setExpiration(tokenEntity.getExpiration());
        tokenDomain.setOwner(tokenEntity.getOwner());
        tokenDomain.setCreatedAt(tokenEntity.getCreatedAt());
        return tokenDomain;
    }

}
