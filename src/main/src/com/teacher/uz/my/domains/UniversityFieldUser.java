package com.teacher.uz.my.domains;

import com.teacher.uz.my.domains.enumerations.TableNames;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Shoh Jahon on 23.04.2018.
 */
@Entity
@Table(name = TableNames.universityFieldUser)
public class UniversityFieldUser implements Serializable{
    private static final Long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "university_id")
    private University university;
    @ManyToOne
    @JoinColumn(name = "field_id")
    private Field field;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @Column(name = "is_active")
    private boolean isActive;

    public UniversityFieldUser() {
        this.isActive = true;
    }

    public static Long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return "UniversityFieldUser{" +
                "id=" + id +
                ", university=" + university +
                ", field=" + field +
                ", user=" + user +
                ", isActive=" + isActive +
                '}';
    }
}
