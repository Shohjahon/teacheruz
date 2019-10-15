package com.teacher.uz.my.domains;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.teacher.uz.my.domains.enumerations.TableNames;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Shoh Jahon on 03.05.2018.
 */
@Entity
@Table(name = TableNames.test)
public class Test implements Serializable{
    private static final Long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "test_title")
    private String testTitle;
    @Column(name = "test_content")
    private String testContent;
    @Column(name = "created_date", nullable = false)
    private Instant createdDate = Instant.now();
    @Column(name = "test_grade")
    private Integer score;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;
    @JsonIgnore
    @OneToMany(mappedBy = "test",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Collection<LogTest> logTests = new ArrayList<>();

    public Test() {
    }


    public Collection<LogTest> getLogTests() {
        return logTests;
    }

    public void setLogTests(Collection<LogTest> logTests) {
        this.logTests = logTests;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getTestContent() {
        return testContent;
    }

    public void setTestContent(String testContent) {
        this.testContent = testContent;
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

    public String getTestTitle() {
        return testTitle;
    }

    public void setTestTitle(String testTitle) {
        this.testTitle = testTitle;
    }

    public Instant getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Instant createdDate) {
        this.createdDate = createdDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
