package com.example.prj321x_project3_tuyenndfx29367.service;


import com.example.prj321x_project3_tuyenndfx29367.dto.reponse.ResponseListPatients;
import com.example.prj321x_project3_tuyenndfx29367.entity.DoctorUser;
import com.example.prj321x_project3_tuyenndfx29367.entity.Patients;

import java.util.List;
import java.util.Optional;

public interface PatientsService {

    Patients savePatients(Patients patients);

    List<ResponseListPatients> findAllByDoctorUser(DoctorUser doctorUser);

   Optional<Patients> findPatientById(int patientId) ;

}
