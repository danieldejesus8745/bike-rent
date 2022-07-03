package com.bikerent.application.ports.inbound;

import com.bikerent.application.domains.Bike;

import java.util.List;
import java.util.UUID;

public interface BikeInboundPort {

    String rentBike(UUID code);

    List<Bike> getAllBikes();

}
