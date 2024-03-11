package com.example.prj321x_project3_tuyenndfx29367.repository;


import com.example.prj321x_project3_tuyenndfx29367.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository <User,Long>{

public User findUserByEmail(String email);


}
