package com.entregafinalspring.entregafinal.models;

import java.time.LocalTime;

public class Appointment {

    private int id;
    private String date;
    private LocalTime hour;

    public Appointment() {
    }

    public Appointment(int id, String date, LocalTime hour) {
        this.id = id;
        this.date = date;
        this.hour = hour;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public LocalTime getHour() {
        return hour;
    }

    public void setHour(LocalTime hour) {
        this.hour = hour;
    }

    @Override
    public String toString() {
        return "Turno{" +
                "id=" + id +
                ", fecha='" + date + '\'' +
                ", hora=" + hour +
                '}';
    }
}
