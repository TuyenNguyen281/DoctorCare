package com.example.prj321x_project3_tuyenndfx29367.service;

import com.example.prj321x_project3_tuyenndfx29367.entity.Clinics;
import com.example.prj321x_project3_tuyenndfx29367.entity.Specialization;

import java.util.List;

public interface SpecializationService {
    public Specialization findSpecializationByName(String name);

    public List<Specialization> listTopSpecialization();
}
