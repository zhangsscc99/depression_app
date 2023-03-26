package com.nyu.model;

import java.time.LocalDateTime;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Document(collection = "replies")
public class Reply {
    
    @Id
    private String id;

    @DBRef
    private Account user;

    @DBRef
    private Post post;

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime lastModifiedDate;

    private String content;

    public Reply(Account user, Post post, String content) {
        super();
        this.user = user;
        this.post = post;
        this.content = content;
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

    public Post getPost() {
        return post;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    
}