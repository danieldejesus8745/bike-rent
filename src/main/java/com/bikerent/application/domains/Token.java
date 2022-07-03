package com.bikerent.application.domains;

import java.time.LocalDate;
import java.util.UUID;

public class Token {

    private String id;
    private UUID token;
    private long expiration;
    private String owner;
    private LocalDate createdAt;

    public void setToken(UUID token) {
        this.token = token;
    }

    public void setExpiration(long expiration) {
        this.expiration = expiration;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public String getId() {
        return id;
    }

    public UUID getToken() {
        return token;
    }

    public long getExpiration() {
        return expiration;
    }

    public String getOwner() {
        return owner;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

}
