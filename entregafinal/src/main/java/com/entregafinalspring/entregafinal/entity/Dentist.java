package com.entregafinalspring.entregafinal.entity;

public class Dentist {

    private int id;
    private String name;
    private String lastname;
    private String registration;

    public Dentist() {
    }

    public Dentist(String name, String lastname, String registration) {
        this.name = name;
        this.lastname = lastname;
        this.registration = registration;
    }

    public Dentist(int id, String name, String lastname, String registration) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.registration = registration;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    @Override
    public String toString() {
        return "Odontologo{" +
                "id=" + id +
                ", nombre='" + name + '\'' +
                ", apellido='" + lastname + '\'' +
                ", matricula='" + registration + '\'' +
                '}';
    }
}
