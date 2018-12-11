package com.wajahat.springfield.business.service;

import com.wajahat.springfield.business.ReservationService;
import com.wajahat.springfield.business.domain.RoomReservation;
import com.wajahat.springfield.data.entity.Room;
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
    public List<RoomReservation> getRoomReservations(String dateString) {
        // Get all the available rooms
        Iterable<Room> rooms = roomRepository.findAll();

        java.sql.Date date = new java.sql.Date(createDate(dateString).getTime());
        Map<Long, RoomReservation> reservationMap = new HashMap<>();

        // Fill the bag with room details
        rooms.forEach(room -> reservationMap.put(room.getId(), RoomReservation.builder()
                .roomId(room.getId())
                .roomName(room.getName())
                .roomNumber(room.getNumber())
                .date(date)
                .build()));

        // Find the reservation by date and fill the bag with guest details
        reservationRepository.findByDate(date).ifPresent(reservations -> reservations.forEach(r-> {
            RoomReservation bag = reservationMap.get(r.getRoomId());
            if (bag != null) {
                guestRepository.findById(r.getGuestId()).ifPresent(guest -> {
                    bag.setGuestId(r.getGuestId());
                    bag.setFirstName(guest.getFirstName());
                    bag.setLastName(guest.getLastName());
                });
            }
        }));

        // return all the reservations
        return new ArrayList<>(reservationMap.values());
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
