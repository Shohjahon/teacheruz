package com.teacher.uz.my.viewmodel;

import com.teacher.uz.my.domains.Field;
import com.teacher.uz.my.domains.University;
import com.teacher.uz.my.domains.User;

import java.io.Serializable;

/**
 * Created by Shoh Jahon on 14.04.2018.
 */
public class RegisterModel implements Serializable {
    private static final Long serialVersionUID = 1L;

    private User user;
    private University university;
    private Field field;

    public static Long getSerialVersionUID() {
        return serialVersionUID;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
}
