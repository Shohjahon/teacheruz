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
@Table(name = "my_group")
public class Group implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "group_number")
    private String groupNumber;
    @JsonIgnore
    @OneToMany(mappedBy = "group",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Collection<TRoomLesson> tRoomLessons = new ArrayList<>();

    public Collection<TRoomLesson> gettRoomLessons() {
        return tRoomLessons;
    }

    public void settRoomLessons(Collection<TRoomLesson> tRoomLessons) {
        this.tRoomLessons = tRoomLessons;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(String groupNumber) {
        this.groupNumber = groupNumber;
    }
}
