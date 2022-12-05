package com.example.servingwebcontent;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;

@Controller
public class AttendanceListController {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@GetMapping("/attendanceList")
	public String attendanceList(Model model) {
		String sql = "select id,date,begin_time,end_time,rest from \"attendances\"";
//		String sql = "select id,date from \"attendances\"";
		List<Map<String, Object>> attendances = this.jdbcTemplate.queryForList(sql);
		model.addAttribute("attendances", attendances);
		return "attendanceList";
	}

	@GetMapping("/attendanceListStart")
	public String hello(@AuthenticationPrincipal MyUserDetails user) {
<<<<<<< HEAD
=======
		System.out.println(user.getUserId());
>>>>>>> reDevelop
		Date date = new Date();
		String strday = new SimpleDateFormat("yyyy-MM-dd").format(date);
		String strtime = new SimpleDateFormat("HH:mm:ss").format(date);
		String struser = user.getUserId();
		String sql = "INSERT INTO Attendances (id,date,begin_time) Values ("+struser+",'"+strday+"','"+strtime+"')";
		this.jdbcTemplate.update(sql);
		return "workplace";
	}

	@GetMapping("/atendanceListEnd")
	public String end(@AuthenticationPrincipal MyUserDetails user){
		String struser = user.getUserId();
		String sql = "SELECT date,begin_time "
				+ "FROM attendances "
				+ "WHERE end_time IS NULL AND id = "
				+ struser;

		Map<String, Object> result = jdbcTemplate.queryForMap(sql);
		System.out.println(result);
		Object stdate = result.get("date");
		Object stbegin_time = result.get("begin_time");
		Date date = new Date();
		String strtime = new SimpleDateFormat("HH:mm:ss").format(date);
		sql = "UPDATE attendances SET end_time = '" + strtime + "' WHERE id = "+struser+" AND date = '" + stdate +
					"' AND begin_time = '" + stbegin_time + "'";
			this.jdbcTemplate.update(sql);

		return "forward:kintai";
	}
}