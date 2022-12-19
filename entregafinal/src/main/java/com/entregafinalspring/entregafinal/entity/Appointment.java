//package com.entregafinalspring.entregafinal.entity;
//
//import javax.persistence.*;
//import java.time.LocalTime;
//import java.util.Date;
//
//@Entity
//@Table(name = "appointment")
//public class Appointment {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private int id;
//
//    private Date date;
//
//    private LocalTime hour;
//    @Column(name = "desc")
//    private String description;
//
//    @OneToOne(mappedBy = "appointment", fetch = FetchType.LAZY)
//    private Dentist dentist;
//
//    public Appointment() {
//    }
//
//    public Appointment(Date date, LocalTime hour, String description) {
//        this.date = date;
//        this.hour = hour;
//        this.description = description;
//    }
//
//    @Override
//    public String toString() {
//        return "Appointment{" +
//                "id=" + id +
//                ", date=" + date +
//                ", hour=" + hour +
//                ", description='" + description + '\'' +
//                '}';
//    }
//}
