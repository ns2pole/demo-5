package com.example.demo.controller;

import com.example.servingwebcontent.ServingWebContentApplication;
import com.example.servingwebcontent.repository.UserRepository;
import com.example.servingwebcontent.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;


@SpringBootTest(classes = ServingWebContentApplication.class)
class UserControllerTest {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    UserRepository userRepository;

    @Test
    public void userCreateTest() throws Exception {
        User user = new User();
        user.setName("test");
        user.setPassword("test");
        user.setRole("ROLE_USER");
        user.setDivision_id(2);
        userRepository.save(user);
        //続きを書く。
    }
}
