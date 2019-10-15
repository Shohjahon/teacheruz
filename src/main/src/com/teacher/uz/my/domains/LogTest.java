package com.teacher.uz.my.domains;

import com.teacher.uz.my.domains.enumerations.TableNames;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Shoh Jahon on 04.05.2018.
 */
@Entity
@Table(name = TableNames.testLog)
public class LogTest implements Serializable{
    private static final Long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "log_id")
    private RepassLog repassLog;
    @ManyToOne
    @JoinColumn(name = "test_id")
    private Test test;

    public LogTest() {
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

    public RepassLog getRepassLog() {
        return repassLog;
    }

    public void setRepassLog(RepassLog repassLog) {
        this.repassLog = repassLog;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }
}
