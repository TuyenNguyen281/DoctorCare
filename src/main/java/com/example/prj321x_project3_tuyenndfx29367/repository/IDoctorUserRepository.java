package com.example.prj321x_project3_tuyenndfx29367.repository;


import com.example.prj321x_project3_tuyenndfx29367.dto.reponse.ResponseDoctorUser;
import com.example.prj321x_project3_tuyenndfx29367.entity.DoctorUser;
import com.example.prj321x_project3_tuyenndfx29367.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public interface IDoctorUserRepository extends JpaRepository<DoctorUser,Long> {

    public Optional<DoctorUser> findDoctorUserByUser(User user);

    @Query("select new com.example.prj321x_project3_tuyenndfx29367.dto.reponse.ResponseDoctorUser(" +
            "doctor_user.id, user.name, user.gender, user.phoneNumber,user.email, user.avatar, " +
            "clinics.name, clinics.address, schedules.sumBooking, schedules.date, schedules.time) " +
            "from DoctorUser doctor_user " +
            "join Clinics clinics " +
            "on doctor_user.clinics = clinics " +
            "join Schedules schedules " +
            "on doctor_user.user = schedules.user " +
            "join User user " +
            "on doctor_user.user = user " +
            "where clinics.address = ?1 and clinics.name = ?2 and schedules.sumBooking = ?3")
    public List<ResponseDoctorUser> findAll1(String city, String hospital, String sumBooking);

    @Query("select new com.example.prj321x_project3_tuyenndfx29367.dto.reponse.ResponseDoctorUser(" +
            "doctor_user.id, user.name, user.gender, user.phoneNumber,user.email, user.avatar, " +
            "clinics.name, clinics.address, schedules.sumBooking, schedules.date, schedules.time, specialization.name) " +
            "from DoctorUser doctor_user " +
            "join Clinics clinics " +
            "on doctor_user.clinics = clinics " +
            "join Schedules schedules " +
            "on doctor_user.user = schedules.user " +
            "join User user " +
            "on doctor_user.user = user " +
            "join Specialization specialization " +
            "on doctor_user.specialization = specialization " +
            "where specialization.name = ?1 ")
    public List<ResponseDoctorUser> findAllBySpecialization(String specialization);

}
