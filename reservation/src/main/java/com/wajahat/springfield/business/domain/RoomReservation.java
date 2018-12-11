package com.wajahat.springfield.business.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;


/**
 * Class Bag for Room, Guest, Reservation
 * Created by wajahat
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoomReservation {
    private Long roomId;
    private Long guestId;
    private String roomName;
    private String roomNumber;
    private String firstName;
    private String lastName;
    private Date date;
}
