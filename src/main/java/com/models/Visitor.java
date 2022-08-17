package com.models;

import javax.persistence.*;

@Entity
@Table(name = "visitor")
public class Visitor {

    @Id
    @Column(name = "visitor_id")
    private int visitorId;

    @Column(name = "dob")
    private String dob;

    @OneToOne(mappedBy = "visitor")
    private User visitor;

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

    public User getVisitor() {
        return visitor;
    }

    public void setVisitor(User visitor) {
        this.visitor = visitor;
    }

}
