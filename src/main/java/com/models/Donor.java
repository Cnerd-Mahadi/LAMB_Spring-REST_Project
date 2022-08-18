package com.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
@Table(name = "donor")
public class Donor {

    @Id
    @Column(name = "donor_id")
    private int donorId;


    @Column(name = "eligibility")
    private String eligibility;

    @Column(name = "last_donate")
    private String lastDonate;

    @Column(name = "blood_type")
    private String bloodType;

    @OneToOne
    @JoinColumn(name = "user_id_fk")
    private User donorUserInfo;
    //@JsonManagedReference
    public User getDonorUserInfo() {
        return donorUserInfo;
    }

    public void setDonorUserInfo(User donorUserInfo) {
        this.donorUserInfo = donorUserInfo;
    }

    public int getDonorId() {
        return donorId;
    }

    public void setDonorId(int donorId) {
        this.donorId = donorId;
    }

    public String getEligibility() {
        return eligibility;
    }

    public void setEligibility(String eligibility) {
        this.eligibility = eligibility;
    }

    public String getLastDonate() {
        return lastDonate;
    }

    public void setLastDonate(String lastDonate) {
        this.lastDonate = lastDonate;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }
}
