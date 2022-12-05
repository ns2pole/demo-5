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
	public String attendanceList(Model model ,@AuthenticationPrincipal MyUserDetails user) {
		String user_id = user.getUserId();
		String sql = "select id,date,begin_time,end_time,rest from attendances " +
				"where user_id = "+user_id;
//		String sql = "select id,date from \"attendances\"";
		List<Map<String, Object>> attendances = this.jdbcTemplate.queryForList(sql);
		model.addAttribute("attendances", attendances);
		return "attendanceList";
	}

	@GetMapping("/attendanceListStart")
	public String hello(@AuthenticationPrincipal MyUserDetails user) {
		String struser = user.getUserId();
		System.out.println(user.getUserId());
		int id = 0;
		try{
			String sql = "SELECT MAX(id) AS MAX_ID FROM attendances";
			Map<String, Object> result = jdbcTemplate.queryForMap(sql);
			id = (int) result.get("MAX_ID")+ 1;
		}catch (Exception e){
			System.out.println("0番目");
		}
		Date date = new Date();
		String strday = new SimpleDateFormat("yyyy-MM-dd").format(date);
		String strtime = new SimpleDateFormat("HH:mm:ss").format(date);
		String sql = "INSERT INTO attendances (id,user_id,date,begin_time)" +
				" Values ("+id+","+struser+",'"+strday+"','"+strtime+"')";
		this.jdbcTemplate.update(sql);
		return "workplace";
	}

	@GetMapping("/atendanceListEnd")
	public String end(@AuthenticationPrincipal MyUserDetails user) {
		String struser = user.getUserId();
		String sql = "SELECT id,user_id,date,begin_time " +
				"FROM attendances " +
				"WHERE end_time IS NULL " +
				"AND user_id = "
				+ struser;

		Map<String, Object> result = jdbcTemplate.queryForMap(sql);
		System.out.println(result);
		Object oid = result.get("id");
		Date date = new Date();
		String strtime = new SimpleDateFormat("HH:mm:ss").format(date);
		sql = "UPDATE attendances " +
				"SET end_time = '" + strtime + "'" +
				"WHERE id = " + oid;
		this.jdbcTemplate.update(sql);

		return "forward:kintai?taikin";
	}
}