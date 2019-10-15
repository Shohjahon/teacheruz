package com.teacher.uz.my.domains;

import com.teacher.uz.my.domains.enumerations.TableNames;

import javax.persistence.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

/**
 * Created by Shoh Jahon on 24.04.2018.
 */
@Entity
@Table(name = TableNames.eduHistory)
public class EducationHistory implements Serializable{
    private static final Long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "university_details")
    private String universityDetails;
    @Column(name = "college_details")
    private String collegeDetails;
    @Column(name = "school_details")
    private String schoolDetails;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @Column(name = "created_date")
    private Date createdDate;

    public EducationHistory() {
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
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

    public String getUniversityDetails() {
        return universityDetails;
    }

    public void setUniversityDetails(String universityDetails) {
        this.universityDetails = universityDetails;
    }

    public String getCollegeDetails() {
        return collegeDetails;
    }

    public void setCollegeDetails(String collegeDetails) {
        this.collegeDetails = collegeDetails;
    }

    public String getSchoolDetails() {
        return schoolDetails;
    }

    public void setSchoolDetails(String schoolDetails) {
        this.schoolDetails = schoolDetails;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
