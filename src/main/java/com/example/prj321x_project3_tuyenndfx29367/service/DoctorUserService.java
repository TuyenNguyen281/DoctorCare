package com.example.prj321x_project3_tuyenndfx29367.service;

import com.example.prj321x_project3_tuyenndfx29367.dto.reponse.ResponseDoctorUser;
import com.example.prj321x_project3_tuyenndfx29367.entity.DoctorUser;
import com.example.prj321x_project3_tuyenndfx29367.entity.User;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface DoctorUserService {
    DoctorUser saveDoctorUser(DoctorUser doctorUser);

    Optional<DoctorUser> findDoctorUserById(int id);

    Optional<DoctorUser> findDoctorUserByUser(User user);

    public List<ResponseDoctorUser> findAll1(String city, String hospital, String sumBooking);
    public List<ResponseDoctorUser> findAllBySpecialization(String specialization);
}
