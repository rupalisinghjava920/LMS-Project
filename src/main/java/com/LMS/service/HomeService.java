package com.LMS.service;

import com.LMS.entity.User;
import com.LMS.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomeService {

    @Autowired
    private UserRepository userRepository;

    public User register(User user){
        return userRepository.save(user);
    }
}
