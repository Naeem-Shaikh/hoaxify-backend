package com.hoaxify.hoaxify.backend.web.controller;

import com.hoaxify.hoaxify.backend.web.model.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;


import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
class UserControllerTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @Test
    public void postUser_whenUserIsValid_receiveOk(){
        User user = new User();
        user.setUserName("test-user");
        user.setUserDisplay("test-display");
        user.setUserPassword("P4sword");
        ResponseEntity<Object> response = testRestTemplate.postForEntity("/api/v1/users", user, Object.class);
        assertEquals(response.getStatusCode(),HttpStatus.OK);
       // assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}