package com.wajahat.springfield.business;

import com.wajahat.springfield.business.domain.RoomReservation;
import com.wajahat.springfield.data.entity.Reservation;

import java.util.List;

/**
 * Class APIs for Reservation Service
 * Created by wajahat
 */
public interface ReservationService {

    List<RoomReservation> getRoomReservations(String dateString);
}
