package com.bikerent.mappers;

import com.bikerent.application.domains.Bike;
import com.bikerent.entities.BikeEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BikeMapper {

    public List<Bike> fromBikeEntityListToBikeList(List<BikeEntity> bikeEntityList) {
        ArrayList<Bike> bikeList = new ArrayList<>();

        for (BikeEntity bikeEntity : bikeEntityList) {
            Bike bike = new Bike();
            bike.setId(bikeEntity.getId());
            bike.setCode(bikeEntity.getCode());
            bike.setAvailable(bikeEntity.isAvailable());
            bike.setUser(bikeEntity.getUser());
            bikeList.add(bike);
        }

        return bikeList;
    }

}
