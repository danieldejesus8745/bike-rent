package com.bikerent.application.domains;

import java.util.UUID;

public class Bike {

    private String id;
    private UUID code;
    private boolean isAvailable;
    private String user;

    public void setId(String id) {
        this.id = id;
    }

    public void setCode(UUID code) {
        this.code = code;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getId() {
        return id;
    }

    public UUID getCode() {
        return code;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public String getUser() {
        return user;
    }
}
