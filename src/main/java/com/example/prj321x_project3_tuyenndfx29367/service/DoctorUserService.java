package com.example.prj321x_project3_tuyenndfx29367.service;

import com.example.prj321x_project3_tuyenndfx29367.entity.DoctorUser;
import com.example.prj321x_project3_tuyenndfx29367.entity.User;

import java.util.Optional;

public interface DoctorUserService {
    DoctorUser saveDoctorUser(DoctorUser doctorUser);

    Optional<DoctorUser> findDoctorUserById(int id);

    Optional<DoctorUser> findDoctorUserByUser(User user);
}
