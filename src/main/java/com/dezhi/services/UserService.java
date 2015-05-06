package com.dezhi.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.dezhi.action.UserEntity;

/**
 *
 * @author dezhi1231
 *
 */
public class UserService implements IUserService {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public UserEntity findUserByUserName(String userName) {
		// TODO Auto-generated method stub

		List<UserEntity> userlist = jdbcTemplate.query(
				"select * from sys_user where username = ?",
				new Object[] { userName }, new RowMapper<UserEntity>() {

					public UserEntity mapRow(ResultSet rs, int row)
							throws SQLException {
						// TODO Auto-generated method stub

						System.out.println("rs." + rs.getString("username"));

						UserEntity userEntity = new UserEntity();

						userEntity.setUsername(rs.getString("username"));

						userEntity.setUserpwd(rs.getString("userpwd"));

						return userEntity;

					}

				});

		System.out.println("userlist:" + userlist.size());

		if (!userlist.isEmpty()) {
			return userlist.get(0);
		} else {
			return null;
		}

	}

	public boolean addUser(UserEntity user) {

		if (user == null) {
			return false;
		}

		int i = jdbcTemplate.update("insert into sys_user(username,userpwd,roleid,create_date) values(?,?,0,now())",
				new Object[] { user.getUsername(), user.getUserpwd() });

		return i > 0;
	}

	public List<UserEntity> findUserList(String userName) {

		String sql = "select * from sys_user where 1 = 1";

		if (userName != null) {

			sql += " and username = '" + userName + "'";

		}

		List<UserEntity> userlist = jdbcTemplate.query(sql,
				new RowMapper<UserEntity>() {
					public UserEntity mapRow(ResultSet rs, int row)
							throws SQLException {
						// TODO Auto-generated method stub

						UserEntity userEntity = new UserEntity();

						userEntity.setId(rs.getInt("id"));

						userEntity.setUsername(rs.getString("username"));

						userEntity.setUserpwd(rs.getString("userpwd"));

						return userEntity;

					}

				});

		return userlist;
	}

	public boolean delUser(int id) {
		// TODO Auto-generated method stub
		
		String sql ="delete from sys_user where id = ?";
		
		return jdbcTemplate.update(sql, new Object[]{id})>0;
		
		
	}

	public boolean updateUser(UserEntity user) {
		// TODO Auto-generated method stub
		return false;
	}

}
