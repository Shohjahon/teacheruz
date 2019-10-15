package com.teacher.uz.my.domains;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.teacher.uz.my.domains.enumerations.TableNames;
import org.hibernate.mapping.Array;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Shoh Jahon on 10.04.2018.
 */
@Entity
@Table(name = TableNames.field)
public class Field implements Serializable{
    private static final Long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "field_code")
    private String fieldCode;
    @Column(name = "field_name")
    private String fieldName;
    private String description;
    @JsonIgnore
    @OneToMany(mappedBy = "field",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Collection<UniversityField> universityFields = new ArrayList<>();
    @JsonIgnore
    @OneToMany(mappedBy = "field",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Collection<UniversityFieldUser> universityFieldUsers = new ArrayList<>();

    public Field() {
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

    public Collection<UniversityField> getUniversityFields() {
        return universityFields;
    }

    public void setUniversityFields(Collection<UniversityField> universityFields) {
        this.universityFields = universityFields;
    }

    @Override
    public String toString() {
        return "Field{" +
                "id=" + id +
                ", fieldCode='" + fieldCode + '\'' +
                ", fieldName='" + fieldName + '\'' +
                ", description='" + description + '\'' +
                ", universityFields=" + universityFields +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFieldCode() {
        return fieldCode;
    }

    public void setFieldCode(String fieldCode) {
        this.fieldCode = fieldCode;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
