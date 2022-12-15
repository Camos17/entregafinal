package com.entregafinalspring.entregafinal.models;

import java.time.LocalTime;
import java.util.Date;

public class Appointment {

    private int id;

    private Date date;

    private LocalTime hour;

    private String description;

    public Appointment() {
    }

    public Appointment(Date date, LocalTime hour, String description) {
        this.date = date;
        this.hour = hour;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", date=" + date +
                ", hour=" + hour +
                ", description='" + description + '\'' +
                '}';
    }
}
