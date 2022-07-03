package com.bikerent.entities;

import com.bikerent.application.domains.Token;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Document("tokens")
public class TokenEntity {

    @Id
    private String id;

    @Indexed(unique = true)
    private UUID token;

    private long expiration;

    @Indexed(unique = true)
    private String owner;

    private LocalDate createdAt;

    public TokenEntity(Token createdToken) {
        id = createdToken.getId();
        token = createdToken.getToken();
        expiration = createdToken.getExpiration();
        owner = createdToken.getOwner();
        createdAt = createdToken.getCreatedAt();
    }

}
