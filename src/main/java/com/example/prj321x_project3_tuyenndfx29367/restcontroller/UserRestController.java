package com.example.prj321x_project3_tuyenndfx29367.restcontroller;

import com.example.prj321x_project3_tuyenndfx29367.dto.reponse.ResponseMassage;
import com.example.prj321x_project3_tuyenndfx29367.entity.*;
import com.example.prj321x_project3_tuyenndfx29367.security.jwt.JwtProvider;
import com.example.prj321x_project3_tuyenndfx29367.service.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/apiUser")
public class UserRestController {

    @Autowired
    private DoctorUserService doctorUserService;
    @Autowired
    private SchedulesService schedulesService;
    @Autowired
    private JwtProvider jwtProvider;
    @Autowired
    private UserService userService;

    @Autowired
    private PatientsService patientsService;

    @Autowired
    private ExtrainfosService extrainfosService;

    @Autowired
    private ClinicsService clinicsService;

    @Autowired
    private SpecializationService specializationService;

    @PostMapping("/BookingCareHealth/{doctorUserId}")
    public ResponseEntity<?> bookingCareHealth(@PathVariable("doctorUserId") int doctorUserId, @RequestParam("schedulesId") int schedulesId, @RequestBody Patients patients, HttpServletRequest request) {

        Optional<DoctorUser> doctorUserOptional = doctorUserService.findDoctorUserById(doctorUserId);
        DoctorUser doctorUser = doctorUserOptional.get();

        Optional<Schedules> schedulesOptional = schedulesService.findSchedulesById(schedulesId);
        Schedules schedules = schedulesOptional.get();

        User user = getUserFromToken(request);

        patients.setDoctorUser(doctorUser);
        patients.setSchedules(schedules);
        patients.setUser(user);

        extrainfosService.saveExtrainfos(patients.getExtrainfos());
        patientsService.savePatients(patients);

        return new ResponseEntity<>(new ResponseMassage(HttpStatus.OK.value(), "BookingCareHealth success!", System.currentTimeMillis()), HttpStatus.OK);

    }

    @GetMapping("/listTopClinics")
     public ResponseEntity<?> listTopClinics() {
        List<Clinics> listTopClinics = clinicsService.listTopClinics();
        return new ResponseEntity<>(listTopClinics, HttpStatus.OK);

    }

    @GetMapping("/listTopSpecialization")
    public ResponseEntity<?> listTopSpecialization() {
        List<Specialization> listTopSpecialization= specializationService.listTopSpecialization();
        return new ResponseEntity<>(listTopSpecialization, HttpStatus.OK);

    }

    private User getUserFromToken(HttpServletRequest request) {
        String token = getJwt(request);
        if (token != null && jwtProvider.validateToken(token)) {
            String username = jwtProvider.getUserNameFromJwtToken(token);
            User user = userService.findUserByEmail(username);
            return user;
        }
        return null;
    }

    private String getJwt(HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");
        if (authHeader != null && authHeader.startsWith("Bearer")) {
            return authHeader.replace("Bearer", "");
        }
        return null;
    }

}
