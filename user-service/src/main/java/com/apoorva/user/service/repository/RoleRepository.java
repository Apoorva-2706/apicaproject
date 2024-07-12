package com.apoorva.user.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apoorva.user.service.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
    Role findByName(String name);
}
