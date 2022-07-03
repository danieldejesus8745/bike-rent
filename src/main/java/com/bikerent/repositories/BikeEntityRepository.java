package com.bikerent.repositories;

import com.bikerent.entities.BikeEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface BikeEntityRepository extends MongoRepository<BikeEntity, String> {

    Optional<BikeEntity> findByCode(UUID code);

}
