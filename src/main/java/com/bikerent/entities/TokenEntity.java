package com.bikerent.entities;

import com.bikerent.application.domains.TokenDomain;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Document("tokens")
@NoArgsConstructor
public class TokenEntity {

    @Id
    private String id;

    @Indexed(unique = true)
    private UUID token;

    private long expiration;

    @Indexed(unique = true)
    private String owner;

    private LocalDate createdAt;

    public TokenEntity(TokenDomain tokenDomain) {
        id = tokenDomain.getId();
        token = tokenDomain.getToken();
        expiration = tokenDomain.getExpiration();
        owner = tokenDomain.getOwner();
        createdAt = tokenDomain.getCreatedAt();
    }

}
