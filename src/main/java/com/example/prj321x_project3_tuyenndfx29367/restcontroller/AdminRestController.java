package com.example.prj321x_project3_tuyenndfx29367.restcontroller;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.example.prj321x_project3_tuyenndfx29367.dto.reponse.ResponseMassage;
import com.example.prj321x_project3_tuyenndfx29367.entity.*;
import com.example.prj321x_project3_tuyenndfx29367.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/apiAdmin")
public class AdminRestController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @Autowired
    private Cloudinary cloudinary;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ClinicsService clinicsService;

    @Autowired
    private SpecializationService specializationService;

    @Autowired
    private DoctorUserService doctorUserService;



    @PostMapping("/registerDoctor")
    public ResponseEntity<?> registerDoctor(@RequestPart("doctorUser") DoctorUser doctorUser, @RequestPart("multipartFile") MultipartFile multipartFile) {

        if (userService.findUserByEmail(doctorUser.getUser().getEmail()) != null) {
            return new ResponseEntity<>(new ResponseMassage(HttpStatus.BAD_REQUEST.value(), "Account is existed", System.currentTimeMillis()), HttpStatus.BAD_REQUEST);
        }
        if (!doctorUser.getUser().getPassword().equals(doctorUser.getUser().getConfirmPassword())) {
            return new ResponseEntity<>(new ResponseMassage(HttpStatus.BAD_REQUEST.value(), "Password and ConfirmPassword different", System.currentTimeMillis()), HttpStatus.BAD_REQUEST);
        }

        Role role = roleService.findRoleByRoleName(doctorUser.getUser().getRole().getRoleName());

        if (role != null) {
            doctorUser.getUser().setRole(role);
        }
        try {
            if (!multipartFile.isEmpty()) {
                Map result = cloudinary.uploader().upload(multipartFile.getBytes(), ObjectUtils.asMap("resource_type", "auto")); //Upload file lên Cloudinary
                String image = (String) result.get("secure_url");   //Lấy đường dẫn file do Cloudinary gửi về
                doctorUser.getUser().setAvatar(image);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        User user = doctorUser.getUser();
        user.setId(0);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setConfirmPassword(passwordEncoder.encode(user.getConfirmPassword()));
        userService.saveUser(user);
        doctorUser.setUser(user);
        Clinics clinics = clinicsService.findClinicsByName(doctorUser.getClinics().getName());
        if(clinics != null) {
            doctorUser.setClinics(clinics);
        }
        Specialization specialization = specializationService.findSpecializationByName(doctorUser.getSpecialization().getName());
        if(specialization !=null) {
            doctorUser.setSpecialization(specialization);
        }

        doctorUserService.saveDoctorUser(doctorUser);
        return new ResponseEntity<>(new ResponseMassage(HttpStatus.OK.value(), "Create success!", System.currentTimeMillis()), HttpStatus.OK);
    }

    @PostMapping("/lockAcct/{usedId}")
    public ResponseEntity<?> lockAcct(@PathVariable("usedId") int usedId, @ModelAttribute("reason") String reasonLockAcct){
        System.out.println(reasonLockAcct);
        Optional<User> optionalUser = userService.findUserById(usedId);
        User user = optionalUser.get();
        user.setStatusLockAcct(0);
        user.setReasionLockAcct(reasonLockAcct);
        userService.saveUser(user);
        return new ResponseEntity<>(new ResponseMassage(HttpStatus.OK.value(), "User lock acct success!", System.currentTimeMillis()), HttpStatus.OK);

    }

}
