package com.example.prj321x_project3_tuyenndfx29367.repository;


import com.example.prj321x_project3_tuyenndfx29367.entity.DoctorUser;
import com.example.prj321x_project3_tuyenndfx29367.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IDoctorUserRepository extends JpaRepository<DoctorUser,Long> {

    public Optional<DoctorUser> findDoctorUserByUser(User user);
}
