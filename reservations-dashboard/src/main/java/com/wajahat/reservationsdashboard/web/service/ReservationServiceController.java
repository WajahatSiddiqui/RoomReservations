package com.wajahat.reservationsdashboard.web.service;

import com.wajahat.reservationsdashboard.web.domain.RoomReservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
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
@RefreshScope
@RequestMapping("/api")
public class ReservationServiceController {
    @Autowired
    private ReservationService reservationService;

    @RequestMapping(method = RequestMethod.GET, value = "/reservations/{date}")
    public List<RoomReservation> getAllReservation(@PathVariable(value = "date  ", required = false) String dateString) {
        return reservationService.getRoomReservations(dateString);
    }
}
