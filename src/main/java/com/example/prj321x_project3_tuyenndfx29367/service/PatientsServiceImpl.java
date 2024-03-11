package com.example.prj321x_project3_tuyenndfx29367.service;

import com.example.prj321x_project3_tuyenndfx29367.dto.reponse.ResponseListPatients;
import com.example.prj321x_project3_tuyenndfx29367.entity.DoctorUser;
import com.example.prj321x_project3_tuyenndfx29367.entity.Patients;
import com.example.prj321x_project3_tuyenndfx29367.repository.IPatientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientsServiceImpl implements PatientsService {
    @Autowired
    private IPatientsRepository patientsRepository;
    @Override
    public Patients savePatients(Patients patients) {
        return patientsRepository.save(patients);
    }


    @Override
    public List<ResponseListPatients> findAllByDoctorUser(DoctorUser doctorUser) {
        return patientsRepository.findAllByDoctorUser(doctorUser);
    }



    @Override
    public Optional<Patients> findPatientById(int patientId) {
        return patientsRepository.findById((long) patientId);
    }


}
