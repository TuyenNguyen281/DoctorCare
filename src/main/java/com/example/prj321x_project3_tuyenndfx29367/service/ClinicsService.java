package com.example.prj321x_project3_tuyenndfx29367.service;

import com.example.prj321x_project3_tuyenndfx29367.entity.Clinics;

import java.util.List;

public interface ClinicsService {
    public Clinics findClinicsByName(String name);

    public List<Clinics> listTopClinics();

}
