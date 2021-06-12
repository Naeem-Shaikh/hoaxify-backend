package com.hoaxify.hoaxify.backend.web.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private String userName;
    private String userDisplay;
    private String userPassword;
}
