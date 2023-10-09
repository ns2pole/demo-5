package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;

@Controller
public class AttendanceListController {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@GetMapping("/attendanceList")
	public String index(Model model) {
		String sql = "select id,begin_time,end_time from attendances ";
		List<Map<String, Object>> attendances = this.jdbcTemplate.queryForList(sql);
		System.out.println(attendances);
		model.addAttribute("attendances", attendances);
		return "roleUser/attendanceList";
	}
}
