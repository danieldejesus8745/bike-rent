package com.bikerent.repositories;

import com.bikerent.entities.TokenEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenEntityRepository extends MongoRepository<TokenEntity, String> {
}
