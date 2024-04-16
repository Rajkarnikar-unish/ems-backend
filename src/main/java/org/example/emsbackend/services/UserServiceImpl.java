package org.example.emsbackend.services;

import org.example.emsbackend.models.User;
import org.example.emsbackend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> getAllUsersByRole(String roleName) {
        return userRepository.getAllUsersByRole(roleName).orElseThrow(() -> new UsernameNotFoundException("User with role ROLE_USER not found"));
    }
}
