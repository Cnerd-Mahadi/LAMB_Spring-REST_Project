package com.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "role")
    private String role;

    @Column(name = "phone")
    private String phone;

    @Column(name = "area")
    private String area;

    @OneToOne(mappedBy = "donorUserInfo")
    private Donor donorInfo;

//    @OneToMany(mappedBy = "postUserInfo")
//    private List<Post> postInfo;
//    @JsonBackReference
//    public List<Post> getPostInfo() {
//        return postInfo;
//    }
//
//    public void setPostInfo(List<Post> postInfo) {
//        this.postInfo = postInfo;
//    }
    @JsonBackReference
    public Donor getDonorInfo() {
        return donorInfo;
    }

    public void setDonorInfo(Donor donorInfo) {
        this.donorInfo = donorInfo;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
