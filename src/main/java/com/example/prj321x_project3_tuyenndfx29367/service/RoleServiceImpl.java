package com.example.prj321x_project3_tuyenndfx29367.service;

import com.example.prj321x_project3_tuyenndfx29367.entity.Role;
import com.example.prj321x_project3_tuyenndfx29367.repository.IRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService{
    @Autowired
    private IRoleRepository roleRepository;
    @Override
    public Role findRoleByRoleName(String name) {
        return roleRepository.findRoleByRoleName(name);
    }
}
