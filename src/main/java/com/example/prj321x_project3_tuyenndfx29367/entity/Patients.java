package com.example.prj321x_project3_tuyenndfx29367.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name="patients")
public class Patients {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name="doctorUser_id")
    private DoctorUser doctorUser;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name="schedules_id")
    private Schedules schedules;

    @OneToOne(targetEntity = Extrainfos.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "extrainfos_id")
    private Extrainfos extrainfos;
    @Column(name="status")
    private String status;
    @Column(name="reason")
    private String reason;

    public Patients() {
    }

    public Patients(User user, DoctorUser doctorUser, Schedules schedules, Extrainfos extrainfos) {
        this.user = user;
        this.doctorUser = doctorUser;
        this.schedules = schedules;
        this.extrainfos = extrainfos;
    }

    public Patients(User user, DoctorUser doctorUser, Schedules schedules, Extrainfos extrainfos, String status, String reason) {
        this.user = user;
        this.doctorUser = doctorUser;
        this.schedules = schedules;
        this.extrainfos = extrainfos;
        this.status = status;
        this.reason = reason;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public DoctorUser getDoctorUser() {
        return doctorUser;
    }

    public void setDoctorUser(DoctorUser doctorUser) {
        this.doctorUser = doctorUser;
    }

    public Extrainfos getExtrainfos() {
        return extrainfos;
    }

    public void setExtrainfos(Extrainfos extrainfos) {
        this.extrainfos = extrainfos;
    }

    public Schedules getSchedules() {
        return schedules;
    }

    public void setSchedules(Schedules schedules) {
        this.schedules = schedules;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "Patients{" +
                "id=" + id +
                ", user=" + user +
                ", doctorUser=" + doctorUser +
                ", schedules=" + schedules +
                ", extrainfos=" + extrainfos +
                '}';
    }
}
