package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

@Controller
public class AttendanceHistoryController {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@GetMapping("/attendanceHistories")
	public String index(Model model) {
		int userId = 1;
		String sql = "select id,date,begin_time,end_time,rest_start_time,rest_end_time from attendances " +
				"where user_id = " + userId;
//		String sql = "select id,date from \"attendances\"";
		List<Map<String, Object>> attendances = this.jdbcTemplate.queryForList(sql);
		model.addAttribute("attendances", attendances);
		return "roleAdmin/attendanceHistories";
	}
}