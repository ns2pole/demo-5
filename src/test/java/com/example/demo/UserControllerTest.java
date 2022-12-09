package com.example.demo;

import com.example.servingwebcontent.ServingWebContentApplication;
import com.example.servingwebcontent.UserAccountDao;
import com.example.servingwebcontent.UserRepository;
import com.example.servingwebcontent.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.jdbc.Sql;

import java.util.Optional;

@SpringBootTest(classes = ServingWebContentApplication.class)
class UserControllerTest {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    //mockMvc TomcatサーバへデプロイすることなくHttpリクエスト・レスポンスを扱うためのMockオブジェクト
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserAccountDao userAccountDao;

    

    @Test
    public void userCreateTest() throws Exception {
        User user = new User();
        user.setId(111);
        user.setName("test");
        user.setPassword("test");
        user.setAuth("USER_ROLE");
        userRepository.save(user);
        Optional<User> newUser = userRepository.findById(11);
        //続きを書く。
    }
}
