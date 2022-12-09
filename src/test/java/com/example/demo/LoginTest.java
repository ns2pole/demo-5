package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import com.example.servingwebcontent.ServingWebContentApplication;
@AutoConfigureMockMvc
@SpringBootTest(classes = ServingWebContentApplication.class)
public class LoginTest {

    //mockMvc TomcatサーバへデプロイすることなくHttpリクエスト・レスポンスを扱うためのMockオブジェクト
    @Autowired
    private MockMvc mockMvc;

    @Test
    void init処理が走って200が返る() throws Exception {
        // andDo(print())でリクエスト・レスポンスを表示
        this.mockMvc.perform(get("/")).andDo(print())
            .andExpect(status().isOk());
    }

    @Test
    void test() throws Exception {
        String result = this.mockMvc.perform(get("/login"))
            .andReturn()
            .getResponse()
            .getContentAsString();
    }

    @Test
    void 直接attendanceListにアクセスしようとすると302が返る() throws Exception {
        this.mockMvc.perform(get("/attendanceList"))
            .andExpect(status().isFound());
    }
}
