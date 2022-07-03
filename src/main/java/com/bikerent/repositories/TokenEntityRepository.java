package com.bikerent.repositories;

import com.bikerent.entities.TokenEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface TokenEntityRepository extends MongoRepository<TokenEntity, String> {

    Optional<TokenEntity> findByOwner(String owner);

    Optional<TokenEntity> findByToken(UUID token);

}
