package com.example.prj321x_project3_tuyenndfx29367.security.userdetail;


import com.example.prj321x_project3_tuyenndfx29367.entity.User;
import com.example.prj321x_project3_tuyenndfx29367.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailService implements UserDetailsService {
    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        System.out.println("222222222222222");
        User user = userService.findUserByEmail(email);
        if (user.getStatusLockAcct() ==1 ) {
            return UserPrinciple.build(user);
        }
        return null;
    }
}
