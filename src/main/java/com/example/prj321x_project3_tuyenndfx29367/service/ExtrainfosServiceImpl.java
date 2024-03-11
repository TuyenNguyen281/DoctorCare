package com.example.prj321x_project3_tuyenndfx29367.service;

import com.example.prj321x_project3_tuyenndfx29367.entity.Extrainfos;
import com.example.prj321x_project3_tuyenndfx29367.entity.Patients;
import com.example.prj321x_project3_tuyenndfx29367.repository.IExtrainfosRepository;
import com.example.prj321x_project3_tuyenndfx29367.repository.IPatientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExtrainfosServiceImpl implements ExtrainfosService {
    @Autowired
    private IExtrainfosRepository extrainfosRepository;
    @Override
    public Extrainfos saveExtrainfos(Extrainfos extrainfos) {
        return extrainfosRepository.save(extrainfos);
    }
}
