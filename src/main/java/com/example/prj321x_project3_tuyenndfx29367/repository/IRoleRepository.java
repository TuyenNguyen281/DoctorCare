package com.example.prj321x_project3_tuyenndfx29367.repository;

import com.example.prj321x_project3_tuyenndfx29367.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoleRepository extends JpaRepository<Role,Long> {
    public Role findRoleByRoleName(String name);



}
