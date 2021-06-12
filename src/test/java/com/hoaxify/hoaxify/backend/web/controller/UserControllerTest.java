package com.hoaxify.hoaxify.backend.web.controller;

import com.hoaxify.hoaxify.backend.web.model.User;
import com.hoaxify.hoaxify.backend.web.repository.UserRepository;
import com.hoaxify.hoaxify.backend.web.shared.GenericeResponse;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.List;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class UserControllerTest {

    public static final String API_V_1_USERS = "/api/v1/users";
    @Autowired
    TestRestTemplate testRestTemplate;

    @Autowired
    UserRepository userRepository;

    @BeforeEach
    public void cleanUp(){
        userRepository.deleteAll();
    }

    @Test
    public void postUser_whenUserIsValid_receiveOk(){
        User user = createValidUser();
        ResponseEntity<Object> response = testRestTemplate.postForEntity(API_V_1_USERS, user, Object.class);
        assertEquals(response.getStatusCode(),HttpStatus.OK);
       // assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
    @Test
    public void postUser_whenUserIsValid_receiveSuccessMessage(){
        User user = createValidUser();
        ResponseEntity<GenericeResponse> response = testRestTemplate.postForEntity(API_V_1_USERS, user, GenericeResponse.class);
        assertNotNull(response.getBody().getMessage());

    }
    @Test
    public void postUser_whenUserIsValid_passwordIsHashInDatabase(){
        User user = createValidUser();
        testRestTemplate.postForEntity("/api/v1/users",user,Object.class);
        List<User> users = userRepository.findAll();
        User inDb = users.get(0);
        assertNotEquals(inDb.getUserPassword(),user.getUserPassword());

    }

    //@org.jetbrains.annotations.NotNull
    private User createValidUser() {
        User user = new User();
        user.setUserName("test-user");
        user.setUserDisplay("test-display");
        user.setUserPassword("P4sword");
        return user;
    }

    @Test
    public void postUser_whenUserIsValid_saveUserToDatabase(){
        User user = createValidUser();
        testRestTemplate.postForEntity(API_V_1_USERS,user,Object.class);
       assertEquals(userRepository.count(),1);

    }
}