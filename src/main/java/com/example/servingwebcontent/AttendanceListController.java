package com.example.servingwebcontent;

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
	public String hello() {
		Date date = new Date();
		String strday = new SimpleDateFormat("yyyy-MM-dd").format(date);
		String strtime = new SimpleDateFormat("HH:mm:ss").format(date);
		String sql = "INSERT INTO Attendances (id,date,begin_time) Values (911,'"+strday+"','"+strtime+"')";
		this.jdbcTemplate.update(sql);
		return "workplace";
	}

	@GetMapping("/atendanceListEnd")
	public String end(){
		String sql = "SELECT date,begin_time "
					+"FROM attendances "
					+"WHERE end_time IS NULL AND id = 911";
		Map<String,Object> result = jdbcTemplate.queryForMap(sql);
		System.out.println(result);
		Object stdate = result.get("date");
		Object stbegin_time = result.get("begin_time");

		if(stdate!=null) {
			Date date = new Date();
			String strtime = new SimpleDateFormat("HH:mm:ss").format(date);
			sql = "UPDATE attendances SET end_time = '" + strtime + "' WHERE id = 911 AND date = '" + stdate +
					"' AND begin_time = '" + stbegin_time + "'";
			this.jdbcTemplate.update(sql);
		}
		return "workplace";
	}
}