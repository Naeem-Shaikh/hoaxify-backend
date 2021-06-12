package com.hoaxify.hoaxify.backend.web.service;

import com.hoaxify.hoaxify.backend.web.model.User;
import com.hoaxify.hoaxify.backend.web.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    UserRepository userRepository ;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User save(User user) {
        return userRepository.save(user);
    }
}
