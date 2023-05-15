package com.coherent.reservations.repository;

import com.coherent.reservations.model.Reservation;

import java.util.List;

public interface ReservationRepository  {

    boolean create(Reservation reservation);

    List<Reservation> findAll();

    boolean update(int id, Reservation reservation);

}
