package com.example.prj321x_project3_tuyenndfx29367.dto.reponse;

public class ResponseDoctorUser {
  private int id;
  private String nameDoctor;
  private String gender;
  private String phoneNumber;
  private String email;
  private String avatar;
  private String hospital;
  private String city;
  private String sumBooking;
  private String date;
  private String time;

  private String specialization;
    public ResponseDoctorUser(int id, String nameDoctor, String gender, String phoneNumber, String email, String avatar, String hospital, String city, String sumBooking, String date, String time) {
        this.id = id;
        this.nameDoctor = nameDoctor;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.avatar = avatar;
        this.hospital = hospital;
        this.city = city;
        this.sumBooking = sumBooking;
        this.date = date;
        this.time = time;
    }

    public ResponseDoctorUser(int id, String nameDoctor, String gender, String phoneNumber, String email, String avatar, String hospital, String city, String sumBooking, String date, String time, String specialization) {
        this.id = id;
        this.nameDoctor = nameDoctor;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.avatar = avatar;
        this.hospital = hospital;
        this.city = city;
        this.sumBooking = sumBooking;
        this.date = date;
        this.time = time;
        this.specialization = specialization;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameDoctor() {
        return nameDoctor;
    }

    public void setNameDoctor(String nameDoctor) {
        this.nameDoctor = nameDoctor;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSumBooking() {
        return sumBooking;
    }

    public void setSumBooking(String sumBooking) {
        this.sumBooking = sumBooking;
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

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
}


