package org.example.emsbackend.services;

import org.example.emsbackend.models.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    public List<User> getAllUsersByRole(String roleName);
}
