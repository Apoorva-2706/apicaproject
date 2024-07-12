package com.apoorva.user.service.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apoorva.user.service.repository.RoleRepository;
import com.apoorva.user.service.model.Role;

@Service
public class RoleSerivce {
    @Autowired
    private RoleRepository roleRepository;

    public Role addRole(Role role){
        return roleRepository.save(role);
    }

    public List<Role> findAll(){
        return roleRepository.findAll();
    }

    public Optional<Role> find(String roleName){
        Optional<Role> role = Optional.ofNullable(roleRepository.findByName(roleName));
        return role;
    }
}
