package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.enums.WorkPlace;
import com.example.servingwebcontent.model.User;
import com.example.servingwebcontent.repository.ContactAddressRepository;
import org.attoparser.dom.Text;
import org.hibernate.boot.registry.classloading.spi.ClassLoaderService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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

	@Autowired
	ContactAddressRepository contactAddressRepository;

	public Map<String,Object> getState(Object user_id) {
		Map<String, Object> result;
		Map<String, Object> state = new HashMap<>();
		try {
			String sql = "SELECT working_status,work_place_id,id FROM attendances " +
					"WHERE id = ( SELECT MAX(id) FROM attendances " +
					"WHERE user_id = " + user_id + ")";
			result = jdbcTemplate.queryForMap(sql);
			WorkPlace[] values = WorkPlace.values();
			WorkPlace workplace = values[(Integer) result.get("work_place_id")];
			switch ((Integer)result.get("working_status")) {
				case 1:
					state.put("working_status", "出勤中");
					state.put("work_place",workplace.displayStr);
					break;
				case 2:
					state.put("working_status","休憩中");
					state.put("work_place",workplace.displayStr);
					break;
				default:
					state.put("working_status","未出勤");
					state.put("work_place","前回:"+workplace.displayStr);
			}
		} catch (Exception e) {
			System.out.println("state取得失敗");
		}
		return state;
	}

	@GetMapping("/attendanceList")
	public String index(Model model,@AuthenticationPrincipal User user) {
		int divisionId = user.getDivisionId();
		List<Map<String,Object>>state = new ArrayList<>();

		String sql = "select name from divisions " +
				"where id = " + divisionId;
		Map<String,Object> division = jdbcTemplate.queryForMap(sql);
		model.addAttribute("division",division.get("name"));

		sql = "select id,name from users " +
				"where division_id  = " + divisionId;
		List<Map<String, Object>> users = this.jdbcTemplate.queryForList(sql);

		for(Map<String,Object> eachuser : users){
			Map<String,Object> one_user = new HashMap<>();
			one_user.put("name",eachuser.get("name"));

			Map<String,Object>result = getState(eachuser.get("id"));
			one_user.put("working_status",result.get("working_status"));
			one_user.put("work_place",result.get("work_place"));
			one_user.put("contact_address",contactAddressRepository.findByUserId((int)eachuser.get("id")).get());			state.add(one_user);
		}
		model.addAttribute("state",state);
		return "roleUser/attendanceList";
	}
}
