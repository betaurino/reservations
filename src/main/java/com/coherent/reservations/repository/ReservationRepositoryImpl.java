package com.coherent.reservations.repository;

import com.coherent.reservations.model.Reservation;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
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

    private static Logger logger = LoggerFactory.getLogger(ReservationRepositoryImpl.class);

    private static final String TEXT_FILENAME = "../db.json";
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

    @PostConstruct
    private void postConstruct() {
        try {
            Path path = Paths.get(TEXT_FILENAME);
            if (Files.exists(path)) {
                String str = Files.readString(path);
                ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());
                repository.addAll(Arrays.asList(mapper.readValue(str, Reservation[].class)));
            }
        } catch (Exception e){
            logger.error(e.toString());
        }
    }

    @PreDestroy
    public void preDestroy() {
        try {
            Path filePath = Paths.get(TEXT_FILENAME);
            Files.deleteIfExists(filePath);
            Files.createFile(filePath);
            ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());
            String jsonRepo = mapper.writeValueAsString(repository);
            Files.writeString(filePath, jsonRepo, StandardOpenOption.WRITE);
        } catch (Exception e){
            logger.error(e.toString());
        }
    }
}
