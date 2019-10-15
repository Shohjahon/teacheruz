package com.teacher.uz.my.domains;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.teacher.uz.my.domains.enumerations.TableNames;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.persistence.Transient;
import java.beans.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

/**
 * Created by Shoh Jahon on 10.04.2018.
 */
@Entity
@Table(name = TableNames.user)
public class User implements Serializable {

    private static final Long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "code")
    private String code;
    @NotBlank
    @Column(name = "first_name")
    private String firstName;
    @NotBlank
    @Column(name = "last_name")
    private String lastName;
    @NotEmpty
    @Column(name = "role")
    private String role;
    @Column(name = "is_active")
    private boolean isActive;
    @NotBlank
    @Column(name = "email")
    private String email;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "password_hash")
    private String password;
    @Transient
    private String confirmPassword;
    @Transient
    private MultipartFile thumbnail;
    @Column(name = "gender")
    private String gender;
    @Transient
    private String fullName;
    @JsonIgnore
    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Collection<UniversityFieldUser> universityFieldUsers = new ArrayList<>();
    @JsonIgnore
    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY, cascade = CascadeType.ALL,orphanRemoval = true)
    private Collection<EducationHistory> educationHistories = new ArrayList<>();
    @JsonIgnore
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Collection<Skill> skills = new ArrayList<>();
    @JsonIgnore
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Collection<Article> articles = new ArrayList<>();
    @JsonIgnore
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Collection<Comment> comments = new ArrayList<>();
    @JsonIgnore
    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Collection<Test> tests = new ArrayList<>();
    @JsonIgnore
    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Collection<TRoomLesson> tRoomLessons = new ArrayList<>();
    @JsonIgnore
    @OneToMany(mappedBy = "student",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Collection<StudentTLesson> studentTLessons = new ArrayList<>();


    public User() {
        this.code = "MYCL"+ UUID.randomUUID().toString().substring(26).toUpperCase();
        isActive = true;
    }

    public Collection<StudentTLesson> getStudentTLessons() {
        return studentTLessons;
    }

    public void setStudentTLessons(Collection<StudentTLesson> studentTLessons) {
        this.studentTLessons = studentTLessons;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Collection<TRoomLesson> gettRoomLessons() {
        return tRoomLessons;
    }

    public void settRoomLessons(Collection<TRoomLesson> tRoomLessons) {
        this.tRoomLessons = tRoomLessons;
    }

    public Collection<Test> getTests() {
        return tests;
    }

    public void setTests(Collection<Test> tests) {
        this.tests = tests;
    }

    public Collection<Comment> getComments() {
        return comments;
    }

    public void setComments(Collection<Comment> comments) {
        this.comments = comments;
    }

    public Collection<Skill> getSkills() {
        return skills;
    }

    public Collection<Article> getArticles() {
        return articles;
    }

    public void setArticles(Collection<Article> articles) {
        this.articles = articles;
    }

    public void setSkills(Collection<Skill> skills) {
        this.skills = skills;
    }

    public Collection<EducationHistory> getEducationHistories() {
        return educationHistories;
    }

    public void setEducationHistories(Collection<EducationHistory> educationHistories) {
        this.educationHistories = educationHistories;
    }

    public Collection<UniversityFieldUser> getUniversityFieldUsers() {
        return universityFieldUsers;
    }

    public void setUniversityFieldUsers(Collection<UniversityFieldUser> universityFieldUsers) {
        this.universityFieldUsers = universityFieldUsers;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public boolean isActive() {
        return isActive;
    }



    public void setActive(boolean active) {
        isActive = active;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


    public static Long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public MultipartFile getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(MultipartFile thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
