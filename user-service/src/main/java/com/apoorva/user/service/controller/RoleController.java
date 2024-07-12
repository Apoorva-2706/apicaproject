package com.apoorva.user.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apoorva.user.service.model.Role;
import com.apoorva.user.service.service.RoleSerivce;

@RestController
@RequestMapping("/api/role")
public class RoleController {
    @Autowired
    private RoleSerivce roleSerivce;

    @PostMapping("/add")
    public ResponseEntity<Role> addRole(@RequestBody Role role){
        return ResponseEntity.ok(roleSerivce.addRole(role));
    }

    @GetMapping("")
    public ResponseEntity<List<Role>> findAll(){
        return ResponseEntity.ok(roleSerivce.findAll());
    }
}
