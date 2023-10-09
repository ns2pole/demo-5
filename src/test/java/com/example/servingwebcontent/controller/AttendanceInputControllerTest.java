package com.example.servingwebcontent.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.web.servlet.MockMvc;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.not;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class AttendanceInputControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private JdbcTemplate jdbcTemplate;


        @Test
        public void testIndex() throws Exception {
            mockMvc.perform(get("/attendanceInput"))
                    .andExpect(status().is(200))
                    .andExpect(content().string(containsString("出勤")))
                    .andExpect(content().string(not(containsString("出勤出勤"))));
        }

        @Test
        public void testAttendwork() throws Exception {
            String expectedTime = new SimpleDateFormat("HH:mm:ss").format(new Date());
            mockMvc.perform(post("/attendwork"))
                    .andExpect(status().is(302))
                    .andExpect(redirectedUrl("attendanceInput"));
            String sql = "SELECT COUNT(*) FROM attendances WHERE begin_time = '" + expectedTime + "'";
            int count = jdbcTemplate.queryForObject(sql, Integer.class);
            assertEquals(1, count);

        }
}