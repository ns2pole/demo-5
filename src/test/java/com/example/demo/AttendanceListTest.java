package com.example.demo;

import com.example.servingwebcontent.ServingWebContentApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest(classes = ServingWebContentApplication.class)
public class AttendanceListTest {

    //mockMvc TomcatサーバへデプロイすることなくHttpリクエスト・レスポンスを扱うためのMockオブジェクト
    @Autowired
    private MockMvc mockMvc;

    // getリクエストでviewを指定し、httpステータスでリクエストの成否を判定
    @Test
    void init処理が走って200が返る() throws Exception {
        // andDo(print())でリクエスト・レスポンスを表示
//        this.mockMvc.perform(get("/attendanceList")).andDo(print())
//            .andExpect(status().isOk());
        this.mockMvc.perform(get("/attendanceList"))
                .andExpect(status().isForbidden());
    }
}
