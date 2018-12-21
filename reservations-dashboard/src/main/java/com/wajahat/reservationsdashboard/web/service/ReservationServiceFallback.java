package com.wajahat.reservationsdashboard.web.service;

import com.wajahat.reservationsdashboard.web.domain.RoomReservation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

/**
 * Class Fallback for Reservation Service
 * Created by wajahat
 */
@Component
@Slf4j
public class ReservationServiceFallback implements ReservationService {
    @Override
    public List<RoomReservation> getRoomReservations(String dateString) {
        log.info("ReservationServiceFallback : getRoomReservations");
        return Collections.emptyList();
    }
}
