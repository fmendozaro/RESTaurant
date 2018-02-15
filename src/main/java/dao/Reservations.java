package dao;

import models.Reservation;

import java.util.List;

public interface Reservations {
    List<Reservation> all();
    List<Reservation> findByUserId(Long userId);
    Long insert(Reservation rsv);
}