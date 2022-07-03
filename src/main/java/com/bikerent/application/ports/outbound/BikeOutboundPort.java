package com.bikerent.application.ports.outbound;

import com.bikerent.application.domains.Bike;

import java.util.List;
import java.util.UUID;

public interface BikeOutboundPort {

    String rentBike(UUID code);

    List<Bike> getAllBikes();

}
