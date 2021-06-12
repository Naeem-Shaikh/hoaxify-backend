package com.hoaxify.hoaxify.backend.web.controller;

import com.hoaxify.hoaxify.backend.web.model.User;
import com.hoaxify.hoaxify.backend.web.service.UserService;
import com.hoaxify.hoaxify.backend.web.shared.GenericeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    UserService userService;



    @PostMapping
    public GenericeResponse createUser(@RequestBody User user){
          userService.save(user);
        return new GenericeResponse("User Saved");
    }
}
