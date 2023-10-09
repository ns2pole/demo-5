package com.example.servingwebcontent.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.containsString;

@SpringBootTest
@AutoConfigureMockMvc
class AttendanceListControllerTest {
    @Autowired
    private MockMvc mockMvc;

    //テスト用dbの値を取得して表示できているかテスト
    @Test
    public void testYourEndpoint() throws Exception {
        mockMvc.perform(get("/attendanceList"))
                .andExpect(content().string(containsString("21:13:28")))
                .andExpect(content().string(containsString("22:16:14")));
    }
}