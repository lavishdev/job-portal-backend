package com.lavish.jobportalbackend.services;


import com.lavish.jobportalbackend.Repository.UserRepository;
import com.lavish.jobportalbackend.dto.RegisterUserRequestDto;
import com.lavish.jobportalbackend.models.Role;
import com.lavish.jobportalbackend.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(RegisterUserRequestDto  registerUserRequestDto) {

        if (userRepository.findByEmail(registerUserRequestDto.getEmail()).isPresent()) {
            throw new RuntimeException("User already exists with this email");
        }
        User user = new User();
        user.setName(registerUserRequestDto.getName());
        user.setEmail(registerUserRequestDto.getEmail());
        user.setPassword(registerUserRequestDto.getPassword());
        user.setRole(registerUserRequestDto.getRole());

        if (registerUserRequestDto.getRole() != null) {
            user.setRole(registerUserRequestDto.getRole());
        } else {
            user.setRole(Role.CANDIDATE);
        }

        user.setEnabled(true);

        return userRepository.save(user);
    }

    public User getUserById(Long userId) {

        return userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
    }


    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


    public User getUserByEmail(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return user;
    }
    public User updateUser(Long userId, User updatedUser) {
        User user = getUserById(userId);
        user.setName(updatedUser.getName());
        user.setEmail(updatedUser.getEmail());
        user.setPassword(updatedUser.getPassword());
        user.setRole(updatedUser.getRole());

        return userRepository.save(user);
    }
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
