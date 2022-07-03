package com.bikerent.application.services;

import com.bikerent.application.domains.Bike;
import com.bikerent.application.ports.outbound.BikeOutboundPort;

import java.util.List;
import java.util.UUID;

public class BikeService {

    private final BikeOutboundPort bikeOutboundPort;

    public BikeService(BikeOutboundPort bikeOutboundPort) {
        this.bikeOutboundPort = bikeOutboundPort;
    }

    public String rentBike(UUID code) {
        return bikeOutboundPort.rentBike(code);
    }

    public List<Bike> getAllBikes() {
        return bikeOutboundPort.getAllBikes();
    }

}
