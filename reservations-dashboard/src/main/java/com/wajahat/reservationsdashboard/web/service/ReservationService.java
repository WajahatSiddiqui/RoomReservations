package com.wajahat.reservationsdashboard.web.service;

import com.wajahat.reservationsdashboard.web.domain.RoomReservation;
import org.springframework.cloud.openfeign.FeignClient;

import java.util.List;

/**
 * Class APIs for Reservation Service
 * Created by wajahat
 */

@FeignClient(name = "reservation")
public interface ReservationService {

    List<RoomReservation> getRoomReservations(String dateString);
}
