package com.teacher.uz.my.domains;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Shoh Jahon on 19.05.2018.
 */
@Entity
@Table(name = "student_teacher_schedule")
public class StudentTLesson implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "student_id")
    private User student;
    @ManyToOne
    @JoinColumn(name = "schedule_id")
    private TRoomLesson tRoomLesson;

    public StudentTLesson() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getStudent() {
        return student;
    }

    public void setStudent(User student) {
        this.student = student;
    }

    public TRoomLesson gettRoomLesson() {
        return tRoomLesson;
    }

    public void settRoomLesson(TRoomLesson tRoomLesson) {
        this.tRoomLesson = tRoomLesson;
    }
}
