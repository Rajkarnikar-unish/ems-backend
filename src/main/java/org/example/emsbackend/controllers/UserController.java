package org.example.emsbackend.controllers;

import org.example.emsbackend.models.User;
import org.example.emsbackend.repositories.UserRepository;
import org.example.emsbackend.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserRepository userRepository;

    UserServiceImpl userService = new UserServiceImpl();

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userRepository.findAll());
    }

    @GetMapping("/user-role")
    public ResponseEntity<?> getAllUsersByRole(@RequestParam String roleName) {
        return ResponseEntity.ok(userService.getAllUsersByRole(roleName));
    }

}
