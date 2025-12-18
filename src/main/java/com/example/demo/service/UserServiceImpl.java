package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepo;
    private final BCryptPasswordEncoder encoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepo) {
        this.userRepo = userRepo;
        this.encoder = new BCryptPasswordEncoder();
    }

    @Override
    public User registerUser(User user) {
        // Encode password
        user.setPassword(encoder.encode(user.getPassword()));

        // Set default role if not provided
        if (user.getRole() == null) {
            user.setRole("USER");
        }

        return userRepo.save(user);
    }
}
