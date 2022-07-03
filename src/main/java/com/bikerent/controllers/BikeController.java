package com.bikerent.controllers;

import com.bikerent.adapters.inbound.BikeInboundAdapter;
import com.bikerent.adapters.inbound.TokenInboundAdapter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static com.bikerent.utils.Messages.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api/v1/bikes")
public class BikeController {

    private final BikeInboundAdapter bikeInboundAdapter;
    private final TokenInboundAdapter tokenInboundAdapter;

    @GetMapping(path = "/{code}")
    public ResponseEntity<String> rentBike(@RequestHeader("Authorization") String token,
                                           @PathVariable("code") String code) {
        boolean isValidToken = tokenInboundAdapter.isValidToken(UUID.fromString(token));

        if (!isValidToken) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(MESSAGE_9.getDescription());
        }

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
    public ResponseEntity<Object> getAllBikes(@RequestHeader("Authorization") String token) {
        boolean isValidToken = tokenInboundAdapter.isValidToken(UUID.fromString(token));

        if (!isValidToken) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(MESSAGE_9.getDescription());
        }

        return ResponseEntity.status(HttpStatus.OK).body(bikeInboundAdapter.getAllBikes());
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
