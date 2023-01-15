package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.enums.WorkPlace;
import com.example.servingwebcontent.model.User;
import org.apache.tomcat.jni.Shm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@Controller
public class AttendanceInputController {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@GetMapping("/attendanceInput")
	public String index(@RequestParam(name = "name", required = false, defaultValue = "World")
							String name, Model model, @AuthenticationPrincipal User user) {
		model.addAttribute("name", name);
		printState(model, user.getId());
		return "roleUser/attendanceInput";
	}

	public Map<String,Object> getState(int user_id) {
		Map<String, Object> result = null;
		try {
			String sql = "SELECT working_status,rest_status FROM attendances " +
					"WHERE id = ( SELECT MAX(id) FROM attendances " +
					"WHERE user_id = " + user_id + ")";
			result = jdbcTemplate.queryForMap(sql);
		} catch (Exception e) {
			System.out.println("state取得失敗");
		}
		return result;
	}
	public void printState(Model model, int user_id) {
		Map<String,Object> state = getState(user_id);
		switch ((Integer) state.get("working_status")) {
			case 1:
				model.addAttribute("state", "状態:出勤中");
				if((Integer)state.get("rest_status")==0) {
					model.addAttribute("error","出勤中です。");
				}else {
					model.addAttribute("error", "出勤中(休憩済み)です。");
				}
				break;

			case 2:
				model.addAttribute("state", "状態:休憩中");
				model.addAttribute("error", "休憩中です。");
				break;

			default:
				model.addAttribute("state", "状態:未出勤");
				model.addAttribute("error","未出勤です。");
		}
		return;
	}

	@GetMapping("/attendwork")
	public String hello(Model model, @AuthenticationPrincipal User user,@RequestParam("place") Object place) {
		int userId = user.getId();
		if ((Integer)getState(userId).get("working_status") == 0) {
			int id = 0;
			try {
				String sql = "SELECT MAX(id) AS MAX_ID FROM attendances";
				Map<String, Object> result = jdbcTemplate.queryForMap(sql);
				id = (int) result.get("MAX_ID") + 1;
			} catch (Exception e) {
				System.out.println("0番目");
			}
			Date date = new Date();
			String strday = new SimpleDateFormat("yyyy-MM-dd").format(date);
			String strtime = new SimpleDateFormat("HH:mm:ss").format(date);
			System.out.println(place);
			String sql = "INSERT INTO attendances (id,user_id,work_place_id,rest_status,working_status,date,begin_time)" +
					" Values (" + id + "," + userId +","+place+",0,1,'" + strday + "','" + strtime + "')";
			this.jdbcTemplate.update(sql);
		} else{
			return "redirect:attendanceInput?error";
		}
		return"redirect:attendanceInput";
	}

	@GetMapping("/leavingwork")
	public String end(Model model, @AuthenticationPrincipal User user) {
		int userId = user.getId();
		if((Integer)getState(userId).get("working_status") == 1) {
			String sql = "SELECT id,user_id,date,begin_time " +
					"FROM attendances " +
					"WHERE end_time IS NULL " +
					"AND user_id = "
					+ userId;

			Map<String, Object> result = jdbcTemplate.queryForMap(sql);
			System.out.println(result);
			Object oid = result.get("id");
			Date date = new Date();
			String strtime = new SimpleDateFormat("HH:mm:ss").format(date);
			sql = "UPDATE attendances " +
					"SET end_time = '" + strtime + "'," +
					"working_status = 0" +
					"WHERE id = " + oid;
			this.jdbcTemplate.update(sql);
		} else{
			return "redirect:attendanceInput?error";
		}
		return "redirect:attendanceInput?taikin";
	}

	@GetMapping("/startrest")
	public String StartRest(Model model, @AuthenticationPrincipal User user) {
		int userId = user.getId();
		if((Integer)getState(userId).get("working_status") == 1
				&& (Integer)getState(userId).get("rest_status") == 0) {
			String sql = "SELECT id,user_id,date,begin_time " +
					"FROM attendances " +
					"WHERE working_status = 1 " +
					"AND user_id = "
					+ userId;

			Map<String, Object> result = jdbcTemplate.queryForMap(sql);
			System.out.println(result);
			Object oid = result.get("id");
			Date date = new Date();
			String strtime = new SimpleDateFormat("HH:mm:ss").format(date);
			sql = "UPDATE attendances " +
					"SET rest_start_time  = '" + strtime + "'," +
					"working_status = 2" +
					"WHERE id = " + oid;
			this.jdbcTemplate.update(sql);
		}else {
			return "redirect:attendanceInput?error";
		}
		return "redirect:attendanceInput";
	}
	@GetMapping("/endrest")
	public String EndRest(Model model, @AuthenticationPrincipal User user) {
		int userId = user.getId();
		if((Integer)getState(userId).get("working_status") == 2) {
			String sql = "SELECT id,user_id,date,begin_time " +
					"FROM attendances " +
					"WHERE working_status = 2 " +
					"AND user_id = "
					+ userId;

			Map<String, Object> result = jdbcTemplate.queryForMap(sql);
			System.out.println(result);
			Object oid = result.get("id");
			Date date = new Date();
			String strtime = new SimpleDateFormat("HH:mm:ss").format(date);
			sql = "UPDATE attendances " +
					"SET rest_end_time  = '" + strtime + "'," +
					"working_status = 1," +
					"rest_status = 1 " +
					"WHERE id = " + oid;
			this.jdbcTemplate.update(sql);
		}else {
			return  "redirect:attendanceInput?error";
		}
		return "redirect:attendanceInput";
	}
}