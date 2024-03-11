package com.example.prj321x_project3_tuyenndfx29367.entity;

import jakarta.persistence.*;

@Entity
@Table(name="extrainfos")
public class Extrainfos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="name")
    private String name;
    @Column(name="gender")
    private String gender;
    @Column(name="phoneNumber")
    private String phoneNumber;
    @Column(name="address")
    private String address;
    @Column(name="reasonForHealth")
    private String reasonForHealth;
    @Column(name="moreInfo", length = 65535)
    private String moreInfo;

    public Extrainfos() {
    }

    public Extrainfos(String name, String gender, String phoneNumber, String address, String reasonForHealth, String moreInfo) {
        this.name = name;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.address = address;
       this.reasonForHealth = reasonForHealth;
        this.moreInfo = moreInfo;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getReasonForHealth() {
        return reasonForHealth;
    }

    public void setReasonForHealth(String reasonForHealth) {
        this.reasonForHealth = reasonForHealth;
    }

    public String getMoreInfo() {
        return moreInfo;
    }

    public void setMoreInfo(String moreInfo) {
        this.moreInfo = moreInfo;
    }
}
