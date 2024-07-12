package com.apoorva.user.service.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
//import org.springframework.security.crypto.password.PasswordEncoder;

import com.apoorva.user.service.model.User;
import com.apoorva.user.service.repository.UserRepository;

import java.util.List;

@Service
public class UserService {
    private static final String USER_EVENTS_TOPIC = "user-events";

    @Autowired
    private UserRepository userRepository;

    //@Autowired
    //private PasswordEncoder passwordEncoder;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;


    //KafkaTemplate

    public User createUser(User user){
        //user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setPassword(user.getPassword());
        User savedUser = userRepository.save(user);
        kafkaTemplate.send(USER_EVENTS_TOPIC, "User added: " + savedUser.getUsername());
        return savedUser;
    }

    public Optional<User> getUser(Long id){
        return userRepository.findById(id);
    }

    public User updateUser(User user){
        User updatedUser = userRepository.save(user);
        kafkaTemplate.send(USER_EVENTS_TOPIC, "User details updated: " + updatedUser.getUsername());
        return updatedUser;
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
        kafkaTemplate.send(USER_EVENTS_TOPIC, "User deleted: " + id);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
