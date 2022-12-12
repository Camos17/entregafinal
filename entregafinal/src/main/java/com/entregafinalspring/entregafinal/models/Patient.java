package com.entregafinalspring.entregafinal.models;

public class Patient {

    private int id;
    private String name;
    private String lastname;
    private String address;
    private String dni;
    private String registrationDate;

    public Patient() {
    }

    public Patient(int id, String name, String lastname, String address, String dni, String registrationDate) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.address = address;
        this.dni = dni;
        this.registrationDate = registrationDate;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "id=" + id +
                ", nombre='" + name + '\'' +
                ", apellido='" + lastname + '\'' +
                ", domicilio='" + address + '\'' +
                ", dni='" + dni + '\'' +
                ", fechaAlta='" + registrationDate + '\'' +
                '}';
    }
}
