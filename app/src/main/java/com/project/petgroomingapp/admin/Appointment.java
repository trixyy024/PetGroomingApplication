package com.project.petgroomingapp.admin;

import java.util.Date;

public class Appointment {
    private Date date;
    private String description;

    public Appointment(Date date, String description) {
        this.date = date;
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }
}
