package com.teacher.uz.my.domains;

import com.teacher.uz.my.domains.enumerations.TableNames;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Shoh Jahon on 24.04.2018.
 */
@Entity
@Table(name = TableNames.skill)
public class Skill implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "skill_name")
    private String skillName;
    @Column(name="skill_trend")
    private Double skillTrend;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @Column(name = "is_active")
    private boolean isActive;
    private static final Long serialVersionUID = 1L;

    public Skill() {
        this.isActive = true;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public Double getSkillTrend() {
        return skillTrend;
    }

    public void setSkillTrend(Double skillTrend) {
        this.skillTrend = skillTrend;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public static Long getSerialVersionUID() {
        return serialVersionUID;
    }
}
