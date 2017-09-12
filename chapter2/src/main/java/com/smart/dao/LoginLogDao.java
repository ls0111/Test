package com.smart.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import com.smart.domain.User;

@Repository
public class LoginLogDao {
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

	public User findUserByUserName(final String userName) {
		final User user = new User();
		jdbcTemplate.query("select * from t_user where user_name = ?", new Object[] { userName },
				new RowCallbackHandler() {

					public void processRow(ResultSet rs) throws SQLException {
						user.setUserId(rs.getInt("user_id"));
						user.setUserName(userName);
						user.setCredits(rs.getInt("credits"));
					}

				});
		return user;
	}

	public void updateLoginInfo(User user) {
		jdbcTemplate.update("update t_user set last_visit=?,last_ip=?,credits=? where user_id=?", user.getLastVisit(),
				user.getLastIp(), user.getCredits());
	}
}
