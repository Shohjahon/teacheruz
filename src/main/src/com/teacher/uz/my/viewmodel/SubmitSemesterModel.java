package com.teacher.uz.my.viewmodel;

import java.io.Serializable;

/**
 * Created by Shoh Jahon on 19.05.2018.
 */
public class SubmitSemesterModel implements Serializable {
    private String password;
    private String email;
    private Integer schedule_id;

    public SubmitSemesterModel() {
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getSchedule_id() {
        return schedule_id;
    }

    public void setSchedule_id(Integer schedule_id) {
        this.schedule_id = schedule_id;
    }

    @Override
    public String toString() {
        return "SubmitSemesterModel{" +
                "password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", schedule_id=" + schedule_id +
                '}';
    }
}
