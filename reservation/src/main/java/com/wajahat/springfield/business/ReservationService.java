package com.wajahat.springfield.business;

import com.wajahat.springfield.business.domain.RoomReservation;
import com.wajahat.springfield.data.domain.Guest;

import java.util.List;

/**
 * Class APIs for Reservation Service
 * Created by wajahat
 */
public interface ReservationService {

    List<Guest> getAllGuest();

    List<RoomReservation> getRoomReservations(String dateString);
}
