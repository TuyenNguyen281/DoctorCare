package com.example.prj321x_project3_tuyenndfx29367.repository;

import com.example.prj321x_project3_tuyenndfx29367.dto.reponse.ResponseListPatients;
import com.example.prj321x_project3_tuyenndfx29367.entity.Clinics;
import com.example.prj321x_project3_tuyenndfx29367.entity.DoctorUser;
import com.example.prj321x_project3_tuyenndfx29367.entity.Patients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IPatientsRepository extends JpaRepository<Patients,Long> {
@Query("select new com.example.prj321x_project3_tuyenndfx29367.dto.reponse.ResponseListPatients(patients.id,patients.schedules.date, patients.schedules.sumBooking, patients.schedules.time, patients.extrainfos) \n" +
        "from Patients patients where  patients.doctorUser = ?1")
public List<ResponseListPatients> findAllByDoctorUser(DoctorUser doctorUser);



}
