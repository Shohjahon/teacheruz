package com.teacher.uz.my.domains;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.teacher.uz.my.domains.enumerations.TableNames;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Shoh Jahon on 24.04.2018.
 */
@Entity
@Table(name = TableNames.subject)
public class Subject implements Serializable{
    private static final Long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "subject_name")
    private String subjectName;
    private String description;
    @JsonIgnore
    @OneToMany(mappedBy = "subject", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Collection<Article> articles = new ArrayList<>();
    @JsonIgnore
    @OneToMany(mappedBy = "subject",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Collection<Test> tests = new ArrayList<>();

    public Subject() {

    }

    public Collection<Test> getTests() {
        return tests;
    }

    public void setTests(Collection<Test> tests) {
        this.tests = tests;
    }

    public Collection<Article> getArticles() {
        return articles;
    }

    public void setArticles(Collection<Article> articles) {
        this.articles = articles;
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

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
