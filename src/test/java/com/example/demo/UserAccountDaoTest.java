package com.example.demo;

import com.example.servingwebcontent.ServingWebContentApplication;
import com.example.servingwebcontent.repository.UserRepository;
import com.example.servingwebcontent.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.jdbc.Sql;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = ServingWebContentApplication.class)
@Sql({"/setup.sql"})

class UserAccountDaoTest {
    //mockMvc TomcatサーバへデプロイすることなくHttpリクエスト・レスポンスを扱うためのMockオブジェクト
    @Autowired
    UserRepository userRepository;


    // 登録されているユーザーを名前で見つけることができるかどうかをテスト
    @Test
    public void findUserByTest() throws Exception {
        Optional<User> user = userRepository.findByName("admin1");
        assertEquals(4, user.get().getId());
    }
}
