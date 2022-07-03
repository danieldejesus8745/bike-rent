package com.bikerent.adapters.outbound;

import com.bikerent.application.domains.Bike;
import com.bikerent.application.ports.outbound.BikeOutboundPort;
import com.bikerent.entities.BikeEntity;
import com.bikerent.mappers.BikeMapper;
import com.bikerent.repositories.BikeEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

import static com.bikerent.utils.Messages.*;

@Service
@RequiredArgsConstructor
public class BikeOutboundAdapter implements BikeOutboundPort {

    private final BikeEntityRepository bikeEntityRepository;
    private final BikeMapper bikeMapper;

    @Override
    public String rentBike(UUID code) {
        BikeEntity bikeEntity = bikeEntityRepository.findByCode(code).orElse(null);

        if (Objects.isNull(bikeEntity)) {
            return MESSAGE_5.getDescription();
        }

        if (!bikeEntity.isAvailable()) {
            return MESSAGE_6.getDescription();
        }

        return MESSAGE_7.getDescription();
    }

    @Override
    public List<Bike> getAllBikes() {
        List<BikeEntity> bikeEntityList = bikeEntityRepository.findAll();

        if (bikeEntityList.isEmpty()) {
            return List.of();
        }

        return bikeMapper.fromBikeEntityListToBikeList(bikeEntityList);
    }

}
