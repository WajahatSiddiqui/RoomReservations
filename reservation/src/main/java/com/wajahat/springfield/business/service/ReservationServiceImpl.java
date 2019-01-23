package com.wajahat.springfield.business.service;

import com.wajahat.springfield.business.ReservationService;
import com.wajahat.springfield.business.domain.RoomReservation;
import com.wajahat.springfield.data.domain.Guest;
import com.wajahat.springfield.data.domain.Room;
import com.wajahat.springfield.data.repository.GuestRepository;
import com.wajahat.springfield.data.repository.ReservationRepository;
import com.wajahat.springfield.data.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Class Service Class to manage reservations
 * Created by wajahat
 */
@Service
public class ReservationServiceImpl implements ReservationService {
    private RoomRepository roomRepository;
    private GuestRepository guestRepository;
    private ReservationRepository reservationRepository;

    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    @Autowired
    public ReservationServiceImpl(RoomRepository roomRepository,
                                  GuestRepository guestRepository,
                                  ReservationRepository reservationRepository) {
        this.roomRepository = roomRepository;
        this.guestRepository = guestRepository;
        this.reservationRepository = reservationRepository;
    }

    @Override
    public List<Guest> getAllGuest() {
        return StreamSupport.stream(guestRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public List<RoomReservation> getRoomReservations(String dateString) {
        java.sql.Date date = new java.sql.Date(createDate(dateString).getTime());
        List<RoomReservation> roomReservations = new ArrayList<>();
        reservationRepository.findByDate(date).ifPresent(
                r-> r.forEach(reservation -> {
                    roomReservations.add(RoomReservation.builder()
                            .roomId(reservation.getRoom().getId())
                            .guestId(reservation.getGuest().getId())
                            .roomName(reservation.getRoom().getName())
                            .roomNumber(reservation.getRoom().getNumber())
                            .firstName(reservation.getGuest().getFirstName())
                            .lastName(reservation.getGuest().getLastName())
                            .date(date).build());
                })
        );
        return roomReservations;
    }

    private Date createDate(String dateString) {
        Date date = null;
        if (dateString != null) {
            try {
                date = DATE_FORMAT.parse(dateString);
            } catch (ParseException e) {
                date = new Date();
            }
        } else {
            date = new Date();
        }
        return date;
    }
}
