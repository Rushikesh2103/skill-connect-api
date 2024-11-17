package com.skillconnect.service;

import com.skillconnect.model.User;
import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getAllUsers();
    Optional<User> getUserById(int id);
    User saveUser(User user);
    void deleteUser(int id);
   
    User findByEmail(String email);
    User findById(int id);
}
