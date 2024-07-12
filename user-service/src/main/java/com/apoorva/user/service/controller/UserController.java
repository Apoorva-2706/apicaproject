package com.apoorva.user.service.controller;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.apoorva.user.service.service.RoleSerivce;
import com.apoorva.user.service.service.UserService;
import com.apoorva.user.service.model.Role;
import com.apoorva.user.service.model.User;

import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private RoleSerivce roleSerivce;
    
    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody User user){
        Optional<Role> role = roleSerivce.find(user.getRole());
        if(role.isPresent()){
            return ResponseEntity.ok(userService.createUser(user));
        }
        return ResponseEntity.ofNullable(null);
        
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id){
        Optional<User> user = userService.getUser(id);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user){
        user.setId(id);
        return ResponseEntity.ok(userService.updateUser(user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("")
    public ResponseEntity<List<User>> listAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }
}
