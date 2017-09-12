package com.smart.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int getMatchCount(String userName, String password) {
		String sql = "select count(1) from t_user where user_name = ? and password = ?";
		List list = jdbcTemplate.queryForList(sql, userName, password);
		if (null == list) {
			return 0;
		}
		return list.size();
	}
}
