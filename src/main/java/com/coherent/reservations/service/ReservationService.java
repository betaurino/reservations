package com.coherent.reservations.service;

import com.coherent.reservations.model.Reservation;

import java.util.List;

public interface ReservationService {
    List<Reservation> readAllReservations ();
    boolean createReservation (Reservation reservation);
    boolean updateReservation (int id, Reservation reservation);
}
