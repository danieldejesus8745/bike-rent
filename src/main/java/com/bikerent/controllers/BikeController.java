package com.bikerent.controllers;

import com.bikerent.adapters.inbound.BikeInboundAdapter;
import com.bikerent.application.domains.Bike;
import com.bikerent.entities.BikeEntity;
import com.bikerent.repositories.BikeEntityRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static com.bikerent.utils.Messages.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api/v1/bikes")
public class BikeController {

    private final BikeInboundAdapter bikeInboundAdapter;

    @GetMapping(path = "/{code}")
    public ResponseEntity<String> rentBike(@PathVariable("code") String code) {
        UUID uuidCode = validateCode(code);
        String response = bikeInboundAdapter.rentBike(uuidCode);

        if (response.equals(MESSAGE_5.getDescription())) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }

        if (response.equals(MESSAGE_6.getDescription())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
        }

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping
    public List<Bike> getAllBikes() {
        return bikeInboundAdapter.getAllBikes();
    }

    private UUID validateCode(String code) {
        try {
            return UUID.fromString(code);
        } catch (IllegalArgumentException illegalArgumentException) {
            log.error("Código UUID inválido. " + illegalArgumentException.getMessage());
            throw new IllegalStateException(MESSAGE_8.getDescription());
        }
    }

}
