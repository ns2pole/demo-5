package com.example.servingwebcontent.Controller;

import com.example.servingwebcontent.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;


@Controller
public class KintaiController {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int getState(int user_id) {
		Map<String, Object> result;
		int state = 0;
		try {
			String sql = "SELECT state, id FROM attendances " +
					"WHERE id = ( SELECT MAX(id) FROM attendances " +
					"WHERE user_id = " + user_id + ")";
			result = jdbcTemplate.queryForMap(sql);
			state = (int) result.get("state");
		} catch (Exception e) {
			System.out.println("state取得失敗");
		}
		return state;
	}

	public void printState(Model model, int user_id) {
		int state = getState(user_id);
		switch (state) {
			case 1:
				model.addAttribute("state", "状態:出勤中");
				model.addAttribute("error","出勤中です。");
				break;

			case 2:
				model.addAttribute("state", "状態:休憩中");
				model.addAttribute("error","休憩中です。");
				break;

			default:
				model.addAttribute("state", "状態:未出勤");
				model.addAttribute("error","未出勤です。");
		}
		return;
	}

	@GetMapping("/kintai")
	public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World")
						   String name, Model model, @AuthenticationPrincipal MyUserDetails user) {
		model.addAttribute("name", name);
		printState(model, user.getId());
		return "kintai";
	}

	@GetMapping("/attendwork")
	public String hello(Model model, @AuthenticationPrincipal MyUserDetails user) {
		int userId = user.getId();
		if (getState(userId) == 0) {
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
			String sql = "INSERT INTO attendances (id,user_id,state,date,begin_time)" +
					" Values (" + id + "," + userId + ",1,'" + strday + "','" + strtime + "')";
			this.jdbcTemplate.update(sql);
			printState(model, userId);
		} else{
			return "redirect:kintai?error";
		}
		return"redirect:kintai";
}

	@GetMapping("/leavingwork")
	public String end(Model model, @AuthenticationPrincipal MyUserDetails user) {
		int userId = user.getId();
		if(getState(userId) == 1) {
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
					"state = 0" +
					"WHERE id = " + oid;
			this.jdbcTemplate.update(sql);
		} else{
			return  "redirect:kintai?error";
		}
		return "redirect:kintai?taikin";
	}

	@GetMapping("/startrest")
	public String StartRest(Model model, @AuthenticationPrincipal MyUserDetails user) {
		int userId = user.getId();
		if(getState(userId) == 1) {
			String sql = "SELECT id,user_id,date,begin_time " +
					"FROM attendances " +
					"WHERE state = 1 " +
					"AND user_id = "
					+ userId;

			Map<String, Object> result = jdbcTemplate.queryForMap(sql);
			System.out.println(result);
			Object oid = result.get("id");
			Date date = new Date();
			String strtime = new SimpleDateFormat("HH:mm:ss").format(date);
			sql = "UPDATE attendances " +
					"SET rest_start_time  = '" + strtime + "'," +
					"state = 2" +
					"WHERE id = " + oid;
			this.jdbcTemplate.update(sql);
		}else {
			return  "redirect:kintai?error";
		}
		return "redirect:kintai";
	}
	@GetMapping("/endrest")
	public String EndRest(Model model, @AuthenticationPrincipal MyUserDetails user) {
		int userId = user.getId();
		if(getState(userId) == 2) {
			String sql = "SELECT id,user_id,date,begin_time " +
					"FROM attendances " +
					"WHERE state = 2 " +
					"AND user_id = "
					+ userId;

			Map<String, Object> result = jdbcTemplate.queryForMap(sql);
			System.out.println(result);
			Object oid = result.get("id");
			Date date = new Date();
			String strtime = new SimpleDateFormat("HH:mm:ss").format(date);
			sql = "UPDATE attendances " +
					"SET rest_end_time  = '" + strtime + "'," +
					"state = 1" +
					"WHERE id = " + oid;
			this.jdbcTemplate.update(sql);
		}else {
			return  "redirect:kintai?error";
		}
		return "redirect:kintai";
	}
}