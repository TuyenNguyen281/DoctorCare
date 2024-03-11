package com.example.prj321x_project3_tuyenndfx29367.repository;

import com.example.prj321x_project3_tuyenndfx29367.entity.Clinics;
import com.example.prj321x_project3_tuyenndfx29367.entity.Specialization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISpecializationRepository extends JpaRepository<Specialization,Long> {
    public Specialization findSpecializationByName(String name);

    @Query("select new com.example.prj321x_project3_tuyenndfx29367.entity.Specialization(specialization.id,specialization.name,specialization.description), count(specialization) " +
            "from Patients patients " +
            "join DoctorUser doctor_user on patients.doctorUser = doctor_user " +
            "join Specialization specialization on doctor_user.specialization = specialization " +
            "group by specialization " +
            "order by count (specialization) " +
            "limit 4")
    public List<Specialization> listTopSpecialization ();
}
