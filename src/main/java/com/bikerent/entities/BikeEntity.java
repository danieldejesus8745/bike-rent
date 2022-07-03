package com.bikerent.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Setter
@Getter
@Document("bikes")
public class BikeEntity {

    @Id
    private String id;

    @Indexed(unique = true)
    private UUID code;

    private boolean isAvailable;

    private String user;

}
