package com.nyu.model;

import java.util.Date;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Document(collection = "reports")
public class Report {
    
    @Id
    private String id;

    @DBRef
    private String user_id;

    @DateTimeFormat(iso = ISO.DATE_TIME)
    private Date date;

    private Float score;
    private String description;

    @Field
    private Boolean starred = false;

    public Report(String user_id, Date date, Float score, String description, Boolean starred) {
        super();
        this.user_id = user_id;
        this.date = date;
        this.score = score;
        this.description = description;
        this.starred = starred;
    }

    public String getId() {
        return id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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