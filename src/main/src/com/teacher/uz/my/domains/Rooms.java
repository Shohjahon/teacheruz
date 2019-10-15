package com.teacher.uz.my.domains;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Shoh Jahon on 18.05.2018.
 */
@Entity
@Table(name = "room")
public class Rooms implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "room_number")
    private String roomNumber;
    @Column(name = "seats")
    private Integer seats;
    @JsonIgnore
    @OneToMany(mappedBy = "room",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Collection<TRoomLesson> tRoomLessons = new ArrayList<>();

    public Rooms(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Rooms() {

    }

    public Integer getSeats() {
        return seats;
    }

    public void setSeats(Integer seats) {
        this.seats = seats;
    }

    public Long getId() {
        return id;
    }

    public Collection<TRoomLesson> gettRoomLessons() {
        return tRoomLessons;
    }

    public void settRoomLessons(Collection<TRoomLesson> tRoomLessons) {
        this.tRoomLessons = tRoomLessons;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }
}
