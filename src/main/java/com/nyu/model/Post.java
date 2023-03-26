package com.nyu.model;

import java.time.LocalDateTime;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Document(collection = "posts")
public class Post {
    
    @Id
    private String id;

    @DBRef(lazy = true)
    private Account user;

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime lastModifiedDate;

    private String title;
    private String content;
    
    @Field
    private String type = "regular";

    public Post(Account user, String title, String content, String type) {
        super();
        this.user = user;
        this.title = title;
        this.content = content;
        this.type = type;
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

    public LocalDateTime getLastModifiedDate() {
        return lastModifiedDate;
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