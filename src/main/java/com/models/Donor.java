package com.models;

import javax.persistence.*;

@Entity
@Table(name = "donor")
public class Donor {

    @Id
    @Column(name = "donor_id", nullable = false)
    private int donorId;

    @Column(name = "area", nullable = false)
    private String area;

    @Column(name = "eligibility", nullable = false)
    private String eligibility;

    @Column(name = "last_donate", nullable = false)
    private String lastDonate;

    @Column(name = "blood_type", nullable = false)
    private String bloodType;

    public int getDonorId() {
        return donorId;
    }

    public void setDonorId(int donorId) {
        this.donorId = donorId;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
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
