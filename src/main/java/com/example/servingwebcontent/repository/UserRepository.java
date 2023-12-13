package com.example.servingwebcontent.repository;

import com.example.servingwebcontent.UserNotFoundException;
import com.example.servingwebcontent.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class UserRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<User> findAll() {
		String sql = "SELECT * FROM users";
		List<User> list = new ArrayList<>();
		List<Map<String, Object>> mapList = jdbcTemplate.queryForList(sql);
		for (int i = 0; i < mapList.size(); i++) {
			Map<String, Object> map = mapList.get(i);
			User user = new User();
			list.add(user);

		}
		return list;
	}

	public void update(User user) {
		String sql = "UPDATE users SET name = ?, password = ?, role = ? WHERE id = ?";
		jdbcTemplate.update(sql, user.getName(), user.getPassword(), user.getRole(), user.getId());
	}

	public void insert(User user) {
		synchronizeSequenceWithMaxId();
		String sql = "INSERT INTO users(name, password, role) VALUES (?,?,?)";
		jdbcTemplate.update(sql, user.getName(), user.getPassword(), user.getRole());
	}

	public void synchronizeSequenceWithMaxId() {
		String maxIdQuery = "SELECT MAX(id) FROM users";
		Long maxId = jdbcTemplate.queryForObject(maxIdQuery, Long.class);
		String sequenceName = "users_id_seq";
		String setvalQuery = "SELECT setval(?, ?)";
		jdbcTemplate.queryForList(setvalQuery,  sequenceName, maxId );
	}

	public Integer getMaxId() {
		String maxIdQuery = "SELECT MAX(id) FROM users";
		return jdbcTemplate.queryForObject(maxIdQuery, Integer.class);
	}

	public void delete(User user) {
		String sql = "DELETE FROM users WHERE id = ?";
		jdbcTemplate.update(sql, user.getId());
	}

	public User findById (int userId) {
		String sql = "SELECT * FROM users WHERE id = ?";
		List<Map<String, Object>> userList = jdbcTemplate.queryForList(sql, userId);
			Map<String, Object> user = userList.get(0);
			return new User();
	}

}