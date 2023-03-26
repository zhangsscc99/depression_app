package com.nyu.model;

import java.time.LocalDateTime;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.annotation.CreatedDate;

@Document(collection = "reports")
public class Report {
    
    @Id
    private String id;

    @DBRef
    private Account user;

    @CreatedDate
    private LocalDateTime createdDate;

    private Float score;
    private String description;

    @Field
    private Boolean starred = false;

    public Report(Account user, Float score, String description, Boolean starred) {
        super();
        this.user = user;
        this.score = score;
        this.description = description;
        this.starred = starred;
    }

    public String getId() {
        return id;
    }

    public Account getUser() {
        return user;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getStarred() {
        return starred;
    }

    public void setStarred(Boolean starred) {
        this.starred = starred;
    }
}