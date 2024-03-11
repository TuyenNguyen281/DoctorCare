package com.example.prj321x_project3_tuyenndfx29367.restcontroller;

import com.example.prj321x_project3_tuyenndfx29367.dto.reponse.JwtResponse;
import com.example.prj321x_project3_tuyenndfx29367.dto.reponse.ResponseListPatients;
import com.example.prj321x_project3_tuyenndfx29367.dto.reponse.ResponseMassage;
import com.example.prj321x_project3_tuyenndfx29367.entity.DoctorUser;
import com.example.prj321x_project3_tuyenndfx29367.entity.Patients;
import com.example.prj321x_project3_tuyenndfx29367.entity.Schedules;
import com.example.prj321x_project3_tuyenndfx29367.entity.User;
import com.example.prj321x_project3_tuyenndfx29367.security.jwt.JwtProvider;
import com.example.prj321x_project3_tuyenndfx29367.security.userdetail.UserPrinciple;
import com.example.prj321x_project3_tuyenndfx29367.service.DoctorUserService;
import com.example.prj321x_project3_tuyenndfx29367.service.PatientsService;
import com.example.prj321x_project3_tuyenndfx29367.service.SchedulesService;
import com.example.prj321x_project3_tuyenndfx29367.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/apiDoctor")
public class DoctorRestController {
    @Autowired
    private SchedulesService schedulesService;
    @Autowired
    private UserService userService;
    @Autowired
    private JwtProvider jwtProvider;
    @Autowired
    private DoctorUserService doctorUserService;
    @Autowired
    private PatientsService patientsService;

    @PostMapping("/addSchedules")
    public ResponseEntity<?> addSchedules(@RequestBody Schedules schedules, HttpServletRequest request) {
        User user = getUserFromToken(request);
        System.out.println(user);

        if (user == null) {
            return new ResponseEntity<>(new ResponseMassage(HttpStatus.BAD_REQUEST.value(), "Doctor account not exist!", System.currentTimeMillis()), HttpStatus.BAD_REQUEST);

        } else {
            schedules.setId(0);
            schedules.setUser(user);
        }

        schedulesService.saveSchedules(schedules);
        return new ResponseEntity<>(new ResponseMassage(HttpStatus.OK.value(), "Create success!", System.currentTimeMillis()), HttpStatus.OK);
    }

    @GetMapping("/listPatients")
    public ResponseEntity<?> listPatients(HttpServletRequest request) {
        User user = getUserFromToken(request);

        Optional<DoctorUser> doctorUserOptional = doctorUserService.findDoctorUserByUser(user);
        DoctorUser doctorUser = doctorUserOptional.get();
        System.out.println("11111111111111111----------------111111111111111111");
       List<ResponseListPatients> listPatients = patientsService.findAllByDoctorUser(doctorUser);


        return ResponseEntity.ok(listPatients);

    }

    @GetMapping("/acceptancePatient/{patientId}")
    public ResponseEntity<?> acceptancePatient(@PathVariable("patientId") int patientId){
        Optional<Patients> patientsOptional = patientsService.findPatientById(patientId);
        Patients patients = patientsOptional.get();
        patients.setStatus("accept");
        patientsService.savePatients(patients);
        return new ResponseEntity<>(new ResponseMassage(HttpStatus.OK.value(), "Patient accept success!", System.currentTimeMillis()), HttpStatus.OK);
    }

    @PostMapping("/rejectPatient/{patientId}")
    public ResponseEntity<?> rejectPatient(@PathVariable("patientId") int patientId, @ModelAttribute("reason") String reason){
        System.out.println(reason);
        Optional<Patients> patientsOptional = patientsService.findPatientById(patientId);
        Patients patients = patientsOptional.get();
        patients.setStatus("reject");
        patients.setReason(reason);
        patientsService.savePatients(patients);
        return new ResponseEntity<>(new ResponseMassage(HttpStatus.OK.value(), "Patient reject success!", System.currentTimeMillis()), HttpStatus.OK);
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
