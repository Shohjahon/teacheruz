package com.teacher.uz.my.domains;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Shoh Jahon on 18.05.2018.
 */
@Entity
@Table(name = "teacher_room_lesson")
public class TRoomLesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "room_id")
    private Rooms room;
    @ManyToOne
    @JoinColumn(name = "lesson_id")
    private Lesson lesson;
    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;
    @Column(name = "day_of_week")
    private String dayOfWeek;
    @Column(name = "pair")
    private Integer pair;
    @Column(name = "number_of_students")
    private Integer numberOfStudents;
    @JsonIgnore
    @OneToMany(mappedBy = "tRoomLesson",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Collection<StudentTLesson> studentTLessons = new ArrayList<>();

    public TRoomLesson() {
        numberOfStudents = 0;
    }

    public Collection<StudentTLesson> getStudentTLessons() {
        return studentTLessons;
    }

    public void setStudentTLessons(Collection<StudentTLesson> studentTLessons) {
        this.studentTLessons = studentTLessons;
    }

    public Integer getNumberOfStudents() {
        return numberOfStudents;
    }

    public void setNumberOfStudents(Integer numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Rooms getRoom() {
        return room;
    }

    public void setRoom(Rooms room) {
        this.room = room;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public Integer getPair() {
        return pair;
    }

    public void setPair(Integer pair) {
        this.pair = pair;
    }

    @Override
    public String toString() {
        return "TRoomLesson{" +
                "id=" + id +
                ", user=" + user.getId()+
                ", room=" + room.getId() +
                ", lesson=" + lesson.getId() +
                ", group=" + group.getId() +
                ", dayOfWeek='" + dayOfWeek + '\'' +
                ", pair=" + pair +
                '}';
    }
}
