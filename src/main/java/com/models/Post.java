package com.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
@Table(name = "post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private int postId;

    @Column(name = "post_details")
    private String postDetails;

    @Column(name = "last_status")
    private String lastStatus;

    @Column(name = "user_id_fk")
    private int  userFK;

    public int getUserFK() {
        return userFK;
    }

    public void setUserFK(int userFK) {
        this.userFK = userFK;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getPostDetails() {
        return postDetails;
    }

    public void setPostDetails(String postDetails) {
        this.postDetails = postDetails;
    }

    public String getLastStatus() {
        return lastStatus;
    }

    public void setLastStatus(String lastStatus) {
        this.lastStatus = lastStatus;
    }


}
