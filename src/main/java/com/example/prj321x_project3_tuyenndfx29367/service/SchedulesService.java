package com.example.prj321x_project3_tuyenndfx29367.service;

import com.example.prj321x_project3_tuyenndfx29367.entity.Schedules;

import java.util.Optional;

public interface SchedulesService {
    Schedules saveSchedules(Schedules schedules);

    Optional<Schedules> findSchedulesById(int id);
}
