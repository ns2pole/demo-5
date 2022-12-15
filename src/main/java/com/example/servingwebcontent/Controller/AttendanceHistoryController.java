package com.example.servingwebcontent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AttendanceHistoryController {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@GetMapping("/attendanceHistories")
	public String index() {
		return "attendanceHistories";
	}

}