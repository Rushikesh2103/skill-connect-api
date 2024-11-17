package com.skillconnect.service;

import com.skillconnect.model.User;
import com.skillconnect.repository.UserRepository;
import com.skillconnect.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }



    @Override
    public User findByEmail(String email) {
    	//System.out.println(email);
        return userRepository.findByEmail(email);
    }

	@Override
	public User findById(int id) {
		
		return userRepository.getById(id);
	}


}
