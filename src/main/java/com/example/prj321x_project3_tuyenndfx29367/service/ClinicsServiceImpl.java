package com.example.prj321x_project3_tuyenndfx29367.service;

import com.example.prj321x_project3_tuyenndfx29367.entity.Clinics;
import com.example.prj321x_project3_tuyenndfx29367.repository.IClinicsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClinicsServiceImpl implements ClinicsService{
    @Autowired
    IClinicsRepository clinicsRepository;
    @Override
    public Clinics findClinicsByName(String name) {
        return clinicsRepository.findClinicsByName(name);
    }

    @Override
    public List<Clinics> listTopClinics() {
        return clinicsRepository.listTopClinics();
    }
}
