package com.nyu.model;

import java.util.Date;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Document(collection = "posts")
public class Post {
    
    @Id
    private String id;

    @DBRef
    private String user_id;

    @DateTimeFormat(iso = ISO.DATE_TIME)
    private Date date;

    private String title;
    private String content;
    
    @Field
    private String type = "regular";

    public Post(String user_id, Date date, String title, String content, String type) {
        super();
        this.user_id = user_id;
        this.date = date;
        this.title = title;
        this.content = content;
        this.type = type;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    
}