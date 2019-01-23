package com.wajahat.springfield.web.service;

import com.wajahat.springfield.business.ReservationService;
import com.wajahat.springfield.business.domain.RoomReservation;
import com.wajahat.springfield.data.domain.Guest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Class Controller APIs for Reservation Service
 * Created by wajahat
 */
@RestController
@RequestMapping("/api")
public class ReservationServiceController {
    @Autowired
    private ReservationService reservationService;

    @RequestMapping(method = RequestMethod.GET, value = "/guests")
    public List<Guest> findAllGuest() {
        return reservationService.getAllGuest();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/reservations/{date}")
    public List<RoomReservation> getAllReservation(@PathVariable(value = "date", required = false) String dateString) {
        return reservationService.getRoomReservations(dateString);
    }
}
