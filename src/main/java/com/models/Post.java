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

    @ManyToOne
    @JoinColumn(name = "user_id_fk")
    private  User postUserInfo;

    @JsonManagedReference
    public User getPostUserInfo() {
        return postUserInfo;
    }

    public void setPostUserInfo(User postUserInfo) {
        this.postUserInfo = postUserInfo;
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
