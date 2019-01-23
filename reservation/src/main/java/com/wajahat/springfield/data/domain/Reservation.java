package com.wajahat.springfield.data.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.sql.Date;

/**
 * Reservation Entity Class
 * Created by wajahat
 */
@Entity
@Table(name = "RESERVATION")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RESERVATION_ID")
    private Long id;


    @OneToOne
    @JoinColumn(name = "ROOM_ID", referencedColumnName = "ROOM_ID")
    private Room room;

    @OneToOne
    @JoinColumn(name = "GUEST_ID", referencedColumnName = "GUEST_ID")
    private Guest guest;

    @Column(name = "RES_DATE")
    private Date date;
}
