package com.coherent.reservations.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;


public class Reservation {
    private int id;
    @NotEmpty
    private String clientFullName;
    @Min(value = 1, message = "Invalid room number")
    private int roomNumber;
    @Size(min = 2, max = 2, message = "Must provide 2 dates")
    private List<LocalDate> reservationDates;


    public Reservation(int id, String clientFullName, int roomNumber, List<LocalDate> reservationDates) {
        this.id = id;
        this.clientFullName = clientFullName;
        this.roomNumber = roomNumber;
        this.reservationDates = reservationDates;
    }

    public Reservation() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClientFullName() {
        return clientFullName;
    }

    public void setClientFullName(String clientFullName) {
        this.clientFullName = clientFullName;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public List<LocalDate> getReservationDates() {
        return reservationDates;
    }

    public void setReservationDates(List<LocalDate> reservationDates) {
        this.reservationDates = reservationDates;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", clientFullName='" + clientFullName + '\'' +
                ", roomNumber=" + roomNumber +
                ", reservationDates=" + reservationDates +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reservation that = (Reservation) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
