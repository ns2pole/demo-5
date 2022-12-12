package com.example.servingwebcontent.Controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.servingwebcontent.MyUserDetails;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;

@Controller
public class AttendanceListController {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@GetMapping("/attendanceList")
	public String attendanceList(Model model, @AuthenticationPrincipal MyUserDetails user) {
		int userId = user.getId();
		String sql = "select id,date,begin_time,end_time,rest_start_time,rest_end_time from attendances " +
				"where user_id = " + userId;
//		String sql = "select id,date from \"attendances\"";
		List<Map<String, Object>> attendances = this.jdbcTemplate.queryForList(sql);
		model.addAttribute("attendances", attendances);
		return "attendanceList";
	}
}
