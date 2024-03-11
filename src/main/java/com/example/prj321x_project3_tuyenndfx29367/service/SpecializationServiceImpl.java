package com.example.prj321x_project3_tuyenndfx29367.service;

import com.example.prj321x_project3_tuyenndfx29367.entity.Specialization;
import com.example.prj321x_project3_tuyenndfx29367.repository.ISpecializationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecializationServiceImpl implements SpecializationService{
    @Autowired
    private ISpecializationRepository specializationRepository;
    @Override
    public Specialization findSpecializationByName(String name) {
        return specializationRepository.findSpecializationByName(name);
    }

    @Override
    public List<Specialization> listTopSpecialization() {
        return specializationRepository.listTopSpecialization();
    }
}
