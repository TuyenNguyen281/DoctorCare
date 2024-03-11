package com.example.prj321x_project3_tuyenndfx29367.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "schedules")
public class Schedules {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;
    @Column(name = "date")
    private String date;
    @Column(name = "time")
    private String time;
    @Column(name = "sumBooking")
    private String sumBooking;

    public Schedules() {
    }

    public Schedules(int id, User user, String date, String time, String sumBooking) {
        this.id = id;
        this.user = user;
        this.date = date;
        this.time = time;
        this.sumBooking = sumBooking;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSumBooking() {
        return sumBooking;
    }

    public void setSumBooking(String sumBooking) {
        this.sumBooking = sumBooking;
    }

    @Override
    public String toString() {
        return "Schedules{" +
                "id=" + id +
                ", user=" + user +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", sumBooking='" + sumBooking + '\'' +
                '}';
    }
}
