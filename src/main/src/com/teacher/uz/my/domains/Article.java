package com.teacher.uz.my.domains;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.teacher.uz.my.domains.enumerations.TableNames;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.UUID;

/**
 * Created by Shoh Jahon on 24.04.2018.
 */
@Entity
@Table(name = TableNames.article)
public class Article implements Serializable{
    private static final Long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "article_name")
    private String articleHeader;
    @Column(name = "article_content")
    private String articleContent;
    @Column(name = "created_date")
    private Date createdDate;
    @Column(name = "user_point")
    private int userPoint;
    @Column(name = "video_url")
    private String videoUrl;
    @Transient
    private MultipartFile videoContent;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;
    @JsonIgnore
    @OneToMany(mappedBy = "article",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Collection<Comment> comments = new ArrayList<>();
    @JsonIgnore
    @OneToMany(mappedBy = "article",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Collection<Thumbnail> thumbnails = new ArrayList<>();

    public Article() {
        createdDate = new Date();
        this.videoUrl = "MYCL"+ UUID.randomUUID().toString().substring(26).toUpperCase();
    }

    public Collection<Thumbnail> getThumbnails() {
        return thumbnails;
    }

    public void setThumbnails(Collection<Thumbnail> thumbnails) {
        this.thumbnails = thumbnails;
    }

    public Collection<Comment> getComments() {
        return comments;
    }

    public MultipartFile getVideoContent() {
        return videoContent;
    }

    public void setVideoContent(MultipartFile videoContent) {
        this.videoContent = videoContent;
    }

    public void setComments(Collection<Comment> comments) {
        this.comments = comments;
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

    public String getArticleHeader() {
        return articleHeader;
    }

    public void setArticleHeader(String articleHeader) {
        this.articleHeader = articleHeader;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public int getUserPoint() {
        return userPoint;
    }

    public void setUserPoint(int userPoint) {
        this.userPoint = userPoint;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
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
