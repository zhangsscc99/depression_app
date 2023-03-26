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
    private String postId;

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime lastModifiedDate;

    private String title;
    private String content;

    public Reply(Account user, String postId, String title, String content) {
        super();
        this.user = user;
        this.postId = postId;
        this.title = title;
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

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
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

    
}