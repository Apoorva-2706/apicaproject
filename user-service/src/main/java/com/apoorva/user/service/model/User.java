package com.apoorva.user.service.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;

import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "app_user")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String email;
    private String password;
    private String fullName;
    private String role;

    // @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    // @JoinTable(name = "user_roles", 
    //             joinColumns = @JoinColumn(name = "user_id"),
    //             inverseJoinColumns = @JoinColumn(name = "role_id")
    //             )
    // private Set<Role> roles;

    


}
