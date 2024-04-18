package com.example.prj321x_project3_tuyenndfx29367.restcontroller;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.example.prj321x_project3_tuyenndfx29367.dto.reponse.JwtResponse;
import com.example.prj321x_project3_tuyenndfx29367.dto.reponse.ResponseMassage;
import com.example.prj321x_project3_tuyenndfx29367.dto.request.LoginForm;
import com.example.prj321x_project3_tuyenndfx29367.entity.Role;
import com.example.prj321x_project3_tuyenndfx29367.entity.User;
import com.example.prj321x_project3_tuyenndfx29367.security.jwt.JwtProvider;
import com.example.prj321x_project3_tuyenndfx29367.security.userdetail.UserPrinciple;
import com.example.prj321x_project3_tuyenndfx29367.service.EmailService;
import com.example.prj321x_project3_tuyenndfx29367.service.RoleService;
import com.example.prj321x_project3_tuyenndfx29367.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;
import java.util.function.Consumer;

@RestController
@RequestMapping("/apiAuthor")
public class AuthorRestController {
    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private Cloudinary cloudinary;

    @Autowired
    JwtProvider jwtProvider;

    @Autowired
    private EmailService emailService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestPart("user") User user, @RequestPart("multipartFile") MultipartFile multipartFile) {


        if (userService.findUserByEmail(user.getEmail()) != null) {
            return new ResponseEntity<>(new ResponseMassage(HttpStatus.BAD_REQUEST.value(), "Account is existed", System.currentTimeMillis()), HttpStatus.BAD_REQUEST);
        }
        if (!user.getPassword().equals(user.getConfirmPassword())) {
            return new ResponseEntity<>(new ResponseMassage(HttpStatus.BAD_REQUEST.value(), "Password and ConfirmPassword different", System.currentTimeMillis()), HttpStatus.BAD_REQUEST);
        }
        Role role = roleService.findRoleByRoleName(user.getRole().getRoleName());

        if (role != null) {
            user.setRole(role);
        }
        try {
            if (!multipartFile.isEmpty()) {
                Map result = cloudinary.uploader().upload(multipartFile.getBytes(), ObjectUtils.asMap("resource_type", "auto")); //Upload file lên Cloudinary
                String image = (String) result.get("secure_url");   //Lấy đường dẫn file do Cloudinary gửi về
                user.setAvatar(image);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        user.setId(0);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setConfirmPassword(passwordEncoder.encode(user.getConfirmPassword()));
        userService.saveUser(user);
        return new ResponseEntity<>(new ResponseMassage(HttpStatus.OK.value(), "Create success!", System.currentTimeMillis()), HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginForm loginForm) {
        try {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginForm.getEmail(), loginForm.getPassword()));

            SecurityContext securityContext = SecurityContextHolder.getContext();
            securityContext.setAuthentication(authentication);
            String token = jwtProvider.createToken(authentication);
            UserPrinciple userPrinciple = (UserPrinciple) authentication.getPrincipal();
            return ResponseEntity.ok(new JwtResponse(token, userPrinciple.getUsername(), userPrinciple.getAuthorities()));
        } catch (Exception e) {
            System.out.println("erorr:   " + e.getMessage());
        }
        return new ResponseEntity<>(new ResponseMassage(HttpStatus.BAD_REQUEST.value(), "Login fail!", System.currentTimeMillis()), HttpStatus.BAD_REQUEST);

    }

    @PostMapping("/resetPassword")
    public ResponseEntity<?> resetPassword (@RequestBody LoginForm loginForm) {
        String newPassword = randomPassword(6);
        System.out.println("newPassword: "+newPassword);

        User user = userService.findUserByEmail(loginForm.getEmail());
        if(user == null) {
            return new ResponseEntity<>(new ResponseMassage(HttpStatus.NOT_FOUND.value(), "Account not exist!", System.currentTimeMillis()), HttpStatus.OK);
        }
            user.setPassword(passwordEncoder.encode(newPassword));
            user.setConfirmPassword(passwordEncoder.encode(newPassword));
            userService.saveUser(user);
            String from = "tuyennuce1@gmail.com";
            String to = loginForm.getEmail();
            String subject = "Reset Password!";
            String content = "New Password : " + newPassword ;
            emailService.sendEmail(from, to,subject,content);                    //Gủi mail
            return new ResponseEntity<>(new ResponseMassage(HttpStatus.OK.value(), "Reset password success!", System.currentTimeMillis()), HttpStatus.OK);

    }



    private String randomPassword(int numberOfCharactor) {
        String digits = "0123456789";
        String alpha = "abcdefghijklmnopqrstuvwxyz";
        String alphaUpperCase = alpha.toUpperCase();
        String specials = "~=+%^*/()[]{}/!@#$?|";
        String ALPHA_NUMERIC = alpha + alphaUpperCase + digits;
        String ALL = alpha + alphaUpperCase + digits + specials;
        List<String> result = new ArrayList<>();
        Random generator = new Random();
        Consumer<String> appendChar = s -> {
            int number = randomNumber(0, s.length() - 1);
            result.add("" + s.charAt(number));
        };
        appendChar.accept(digits);
        appendChar.accept(specials);
        while (result.size() < numberOfCharactor) {
            appendChar.accept(ALL);
        }
        Collections.shuffle(result, generator);
        return String.join("", result);
    }

    private int randomNumber(int min, int max) {
        Random generator = new Random();
        return generator.nextInt((max - min) + 1) + min;
    }
}
