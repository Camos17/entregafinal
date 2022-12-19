package com.entregafinalspring.entregafinal.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity // Mapea esta clase con una entidad de BD
@Table(name = "dentist")
public class Dentist {

    @Id // Define cul es la propiedad que sera la primary key
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "lastname")
    private String lastname;
    @Column(name = "registration")
    private String registration;

    // Se establece una relación entre Odontologo y Paciente
    @OneToMany(mappedBy = "dentist", fetch = FetchType.LAZY)
    private Set<Patient> patients = new HashSet<>();

//    @OneToOne()
//    @JoinColumn(name = "appointment_id", referencedColumnName = "id")
//    private Appointment appointment;

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
