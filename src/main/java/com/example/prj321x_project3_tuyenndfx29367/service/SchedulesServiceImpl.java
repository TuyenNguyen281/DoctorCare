package com.example.prj321x_project3_tuyenndfx29367.service;

import com.example.prj321x_project3_tuyenndfx29367.entity.Schedules;
import com.example.prj321x_project3_tuyenndfx29367.repository.ISchedulesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SchedulesServiceImpl implements SchedulesService{
    @Autowired
    private ISchedulesRepository schedulesRepository;
    @Override
    public Schedules saveSchedules(Schedules schedules) {
        return schedulesRepository.save(schedules);
    }

    @Override
    public Optional<Schedules> findSchedulesById(int id) {
        return schedulesRepository.findById((long) id);
    }
}
