package com.models;

import javax.persistence.*;

@Entity
@Table(name = "visitor")
public class Visitor {

    @Id
    @Column(name = "visitor_id", nullable = false)
    private int visitorId;

    @Column(name = "dob", nullable = false)
    private String dob;

    public int getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(int visitorId) {
        this.visitorId = visitorId;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }
}
