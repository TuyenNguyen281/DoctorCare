package com.example.prj321x_project3_tuyenndfx29367.repository;

import com.example.prj321x_project3_tuyenndfx29367.entity.Schedules;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISchedulesRepository extends JpaRepository<Schedules, Long> {
}
