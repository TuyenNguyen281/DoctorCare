package com.example.prj321x_project3_tuyenndfx29367.dto.reponse;

import com.example.prj321x_project3_tuyenndfx29367.entity.Extrainfos;
import com.example.prj321x_project3_tuyenndfx29367.entity.Schedules;

public class ResponseListPatients {
    private int id;
    private String date;
    private String sumBooking;
    private String time;

    private Extrainfos extrainfos;

    public ResponseListPatients() {
    }
    public ResponseListPatients(int id, String date, String sumBooking, String time, Extrainfos extrainfos) {
        this.id = id;
        this.date = date;
        this.sumBooking = sumBooking;
        this.time = time;
        this.extrainfos = extrainfos;
    }



    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSumBooking() {
        return sumBooking;
    }

    public void setSumBooking(String sumBooking) {
        this.sumBooking = sumBooking;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Extrainfos getExtrainfos() {
        return extrainfos;
    }

    public void setExtrainfos(Extrainfos extrainfos) {
        this.extrainfos = extrainfos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
