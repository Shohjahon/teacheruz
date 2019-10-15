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
@Table(name = "lesson")
public class Lesson implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "lesson_name")
    private String lessonName;
    private String description;
    @JsonIgnore
    @OneToMany(mappedBy = "lesson",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Collection<TRoomLesson> tRoomLessons = new ArrayList<>();

    public Lesson() {
    }

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

    public String getLessonName() {
        return lessonName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
