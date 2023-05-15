package com.coherent.reservations.service;

import com.coherent.reservations.model.Reservation;
import com.coherent.reservations.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class ReservationServiceImpl implements ReservationService {

    private final Random random = new Random();
    @Autowired
    ReservationRepository reservationRepository;

    @Override
    public List<Reservation> readAllReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public boolean createReservation(Reservation reservation) {
        reservation.setId(random.nextInt(9999));
        return reservationRepository.create(reservation);
    }

    @Override
    public boolean updateReservation(int id, Reservation reservation) {
        return reservationRepository.update(id, reservation);
    }
}
