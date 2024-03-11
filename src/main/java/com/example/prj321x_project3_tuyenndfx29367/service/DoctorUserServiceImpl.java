package com.example.prj321x_project3_tuyenndfx29367.service;

import com.example.prj321x_project3_tuyenndfx29367.entity.DoctorUser;
import com.example.prj321x_project3_tuyenndfx29367.entity.User;
import com.example.prj321x_project3_tuyenndfx29367.repository.IDoctorUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DoctorUserServiceImpl implements DoctorUserService{
    @Autowired
    private IDoctorUserRepository doctorUserRepository;
    @Override
    public DoctorUser saveDoctorUser(DoctorUser doctorUser) {
        return doctorUserRepository.save(doctorUser);
    }

    @Override
    public Optional<DoctorUser> findDoctorUserById(int id) {
        return doctorUserRepository.findById((long) id);
    }

    @Override
    public Optional<DoctorUser> findDoctorUserByUser(User user) {
        return doctorUserRepository.findDoctorUserByUser(user);
    }


}
