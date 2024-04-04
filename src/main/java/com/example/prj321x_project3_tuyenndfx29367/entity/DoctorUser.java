package com.example.prj321x_project3_tuyenndfx29367.entity;

import jakarta.persistence.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name="doctorUser")
public class DoctorUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name="specialization_id")
    private Specialization specialization;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name="clinics_id")
    private Clinics clinics;

    @OneToOne(targetEntity = User.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name="createdAt")
    private String createdAt;

    public DoctorUser() {
        this.createdAt = (new SimpleDateFormat("yyyy-MM-dd")).format(new Date());

    }

    public DoctorUser(int id, Specialization specialization, Clinics clinics, User user) {
        this.id = id;
        this.specialization = specialization;
        this.clinics = clinics;
        this.user = user;
        this.createdAt = (new SimpleDateFormat("yyyy-MM-dd")).format(new Date());

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Specialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }

    public Clinics getClinics() {
        return clinics;
    }

    public void setClinics(Clinics clinics) {
        this.clinics = clinics;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "DoctorUser{" +
                "id=" + id +
                ", specialization=" + specialization +
                ", clinics=" + clinics +
                ", user=" + user +
                ", createdAt='" + createdAt + '\'' +
                '}';
    }

}