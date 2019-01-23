package com.wajahat.springfield.web.controller;

import com.wajahat.springfield.business.ReservationService;
import com.wajahat.springfield.business.domain.RoomReservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Class Rest Controller for Reservations
 * Created by wajahat
 */
@RestController
@RequestMapping(value="/reservations")
public class ReservationsController {

    @Autowired
    private ReservationService reservationService;

    @RequestMapping(method= RequestMethod.GET)
    public String getReservations(@RequestParam(value="date", required=false) String dateString, Model model){
        List<RoomReservation> roomReservationList = this.reservationService.getRoomReservations(dateString);
        model.addAttribute("roomReservations", roomReservationList);
        return "reservations";
    }
}
