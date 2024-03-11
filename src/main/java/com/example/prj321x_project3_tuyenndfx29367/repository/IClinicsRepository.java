package com.example.prj321x_project3_tuyenndfx29367.repository;

import com.example.prj321x_project3_tuyenndfx29367.entity.Clinics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IClinicsRepository extends JpaRepository<Clinics,Long> {
    public Clinics findClinicsByName(String name);


    @Query("select new com.example.prj321x_project3_tuyenndfx29367.entity.Clinics(clinics.id,clinics.name,clinics.address, clinics.phoneNumber, clinics.description ), count(clinics) " +
            "from Patients patients " +
            "join DoctorUser doctor_user on patients.doctorUser = doctor_user " +
            "join Clinics clinics on doctor_user.clinics = clinics " +
            "group by clinics " +
            "order by count (clinics) " +
            "limit 4")
    public List<Clinics> listTopClinics ();
}
