package com.wajahat.reservationsdashboard.web.controller;

import com.wajahat.reservationsdashboard.web.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Class Rest Controller for Reservations
 * Created by wajahat
 */
@RestController
@RefreshScope
@RequestMapping(value="/reservations")
public class ReservationsController {

    @Autowired
    private ReservationService reservationService;

    @RequestMapping(method= RequestMethod.GET)
    public String getReservations(@RequestParam(value="date", required=false) String dateString, Model model){
        model.addAttribute("roomReservations", this.reservationService.getRoomReservations(dateString));
        return "reservations";
    }
}
