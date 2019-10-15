package com.teacher.uz.my.domains;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.teacher.uz.my.domains.enumerations.TableNames;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Shoh Jahon on 10.04.2018.
 */
@Entity
@Table(name = TableNames.university)
public class University implements Serializable {
    private static final Long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "university_name")
    private String universityName;
    private String description;
    private String address;
    private String phone;
    @Column(name = "web_site")
    private String webSite;
    private String rector;
    @JsonIgnore
    @OneToMany(mappedBy = "university",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Collection<UniversityField> universityFields = new ArrayList<>();
    @JsonIgnore
    @OneToMany(mappedBy = "university",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Collection<UniversityFieldUser> universityFieldUsers = new ArrayList<>();

    public University() {
    }

    public static Long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Collection<UniversityFieldUser> getUniversityFieldUsers() {
        return universityFieldUsers;
    }

    public void setUniversityFieldUsers(Collection<UniversityFieldUser> universityFieldUsers) {
        this.universityFieldUsers = universityFieldUsers;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRector() {
        return rector;
    }

    public void setRector(String rector) {
        this.rector = rector;
    }

    public Collection<UniversityField> getUniversityFields() {
        return universityFields;
    }

    public void setUniversityFields(Collection<UniversityField> universityFields) {
        this.universityFields = universityFields;
    }
}
