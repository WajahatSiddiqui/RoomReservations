package com.wajahat.springfield.data.repository;

import com.wajahat.springfield.data.domain.Reservation;
import org.springframework.data.repository.CrudRepository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

/**
 * Class {@link CrudRepository} for {@link Reservation}
 * Created by wajahat
 */
public interface ReservationRepository extends CrudRepository<Reservation, Long> {
    Optional<List<Reservation>> findByDate(Date date);
}
