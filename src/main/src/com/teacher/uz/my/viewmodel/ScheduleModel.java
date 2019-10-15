package com.teacher.uz.my.viewmodel;

import java.io.Serializable;

/**
 * Created by Shoh Jahon on 20.05.2018.
 */
public class ScheduleModel implements Serializable {
    private int userId;
    private String dayOfWeek;
    private int pair;
    private int roomId;
    private int subjectId;
    private int groupId;

    public ScheduleModel() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public int getPair() {
        return pair;
    }

    public void setPair(int pair) {
        this.pair = pair;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    @Override
    public String toString() {
        return "ScheduleModel{" +
                "userId=" + userId +
                ", dayOfWeek='" + dayOfWeek + '\'' +
                ", pair=" + pair +
                ", roomId=" + roomId +
                ", subjectId=" + subjectId +
                ", groupId=" + groupId +
                '}';
    }
}
