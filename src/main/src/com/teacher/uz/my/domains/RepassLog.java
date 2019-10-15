package com.teacher.uz.my.domains;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.teacher.uz.my.domains.enumerations.TableNames;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * Created by Shoh Jahon on 03.05.2018.
 */
@Entity
@Table(name = TableNames.repassLog)
public class RepassLog implements Serializable {
    private static final Long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "start_date")
    private Date testDate;
    @Column(name = "finish_date")
    private Date finishDate;
    private Integer score;
    private Integer attempts;
    @JsonIgnore
    @OneToMany(mappedBy = "repassLog",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Collection<LogTest> logTests = new ArrayList<>();

    public RepassLog() {
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

    public Date getTestDate() {
        return testDate;
    }

    public void setTestDate(Date testDate) {
        this.testDate = testDate;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getAttempts() {
        return attempts;
    }

    public void setAttempts(Integer attempts) {
        this.attempts = attempts;
    }

    public Collection<LogTest> getLogTests() {
        return logTests;
    }

    public void setLogTests(Collection<LogTest> logTests) {
        this.logTests = logTests;
    }
}
