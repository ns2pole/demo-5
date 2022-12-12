package com.example.servingwebcontent.Controller;

import com.example.servingwebcontent.MyUserDetails;
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
public class KintaiController {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@GetMapping("/kintai")
	public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		model.addAttribute("name", name);
		return "kintai";
	}
	@GetMapping("/attendwork")
	public String hello(@AuthenticationPrincipal MyUserDetails user) {
		int userId = user.getId();
		System.out.println(user.getId());
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
				" Values ("+id+","+userId+",'"+strday+"','"+strtime+"')";
		this.jdbcTemplate.update(sql);
		return "redirect:kintai";
	}

	@GetMapping("/leavingwork")
	public String end(@AuthenticationPrincipal MyUserDetails user) {
		int userId = user.getId();
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
				"SET end_time = '" + strtime + "'" +
				"WHERE id = " + oid;
		this.jdbcTemplate.update(sql);

		return "redirect:kintai?taikin";
	}
}