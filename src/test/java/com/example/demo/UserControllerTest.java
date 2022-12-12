package com.example.demo;

import com.example.servingwebcontent.ServingWebContentApplication;
import com.example.servingwebcontent.repository.UserRepository;
import com.example.servingwebcontent.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Optional;

@SpringBootTest(classes = ServingWebContentApplication.class)
class UserControllerTest {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    //mockMvc TomcatサーバへデプロイすることなくHttpリクエスト・レスポンスを扱うためのMockオブジェクト
    @Autowired
    UserRepository userRepository;

    @Test
    public void userCreateTest() throws Exception {
        User user = new User();
        user.setId(1111);
        user.setName("test");
        user.setPassword("test");
        user.setRole("USER_ROLE");
        userRepository.save(user);
        Optional<User> newUser = userRepository.findById(113);
        //続きを書く。
    }
}
