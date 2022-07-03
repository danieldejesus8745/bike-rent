package com.bikerent.adapters.inbound;

import com.bikerent.application.domains.Bike;
import com.bikerent.application.ports.inbound.BikeInboundPort;
import com.bikerent.application.services.BikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BikeInboundAdapter implements BikeInboundPort {

    private final BikeService bikeService;

    @Override
    public String rentBike(UUID code) {
        return bikeService.rentBike(code);
    }

    @Override
    public List<Bike> getAllBikes() {
        return bikeService.getAllBikes();
    }

}
