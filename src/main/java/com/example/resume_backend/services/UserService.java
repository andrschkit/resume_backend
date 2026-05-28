package com.example.resume_backend.services;

import com.example.resume_backend.entities.User;
import com.example.resume_backend.exceptions.NotFoundException;
import com.example.resume_backend.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import static com.example.resume_backend.utils.StaticStrings.NOT_FOUND_EXCEPTION_USER_ID;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {this.userRepository = userRepository;}

    public User findUserById(Long id) {return userRepository.findById(id)
            .orElseThrow(()-> new NotFoundException(NOT_FOUND_EXCEPTION_USER_ID, id.toString()));}

    public ArrayList<User> findAllUsers() {return userRepository.findAllByOrderByIdAsc();}
}
