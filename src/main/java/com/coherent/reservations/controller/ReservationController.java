package com.coherent.reservations.controller;

import com.coherent.reservations.model.Reservation;
import com.coherent.reservations.service.ReservationService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("hotel")
public class ReservationController {

    @Autowired
    ReservationService reservationService;

    @GetMapping("/reservations")
    public ResponseEntity<List<Reservation>> readAllReservations (){
        List<Reservation> reservations = reservationService.readAllReservations();
        if (reservations.size() == 0){
            return new ResponseEntity<>(Collections.emptyList(), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(reservations, HttpStatus.OK);
    }
    @PostMapping("/reservations")
    public ResponseEntity<?> createReservation (@Valid @RequestBody Reservation reservation){
        if (!reservationService.createReservation(reservation)){
            return new ResponseEntity<>("No reservation created", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(reservation, HttpStatus.CREATED);
    }
    @PutMapping("/reservations/{id}")
    public ResponseEntity<?> updateReservation (@PathVariable int id, @Valid @RequestBody Reservation reservation){
        if (!reservationService.updateReservation(id, reservation)){
            return new ResponseEntity<>("No reservation updated", HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(reservation, HttpStatus.OK);
    }

}
