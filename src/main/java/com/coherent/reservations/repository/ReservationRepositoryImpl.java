package com.coherent.reservations.repository;

import com.coherent.reservations.model.Reservation;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;


@Repository
public class ReservationRepositoryImpl implements ReservationRepository {

    private static final URI TEXT_FILENAME = URI.create("../db.json");
    private final Set<Reservation> repository;

    public ReservationRepositoryImpl() {
        this.repository = new HashSet<>();
    }

    @Override
    public boolean create(Reservation reservation) {
        return repository.add(reservation);
    }

    @Override
    public List<Reservation> findAll() {
        return new LinkedList<>(repository);
    }

    @Override
    public boolean update(int id, Reservation reservation) {
        Reservation oldReservation = new Reservation();
        oldReservation.setId(id);

        if (repository.remove(oldReservation)){
            reservation.setId(id);
            repository.add(reservation);
            return true;
        }
        return false;
    }
}
