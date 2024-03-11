package com.example.prj321x_project3_tuyenndfx29367.service;

import com.example.prj321x_project3_tuyenndfx29367.entity.User;

import java.util.Optional;


public interface UserService {
    public User findUserByEmail(String email);

    User saveUser(User user);

    public Optional<User> findUserById(long id);

}
