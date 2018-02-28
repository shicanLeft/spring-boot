package com.example.springboot_jdbc.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.springboot_jdbc.pojo.User;

/**
 * 事务层
 * @author SHICAN
 *
 */
@Repository
public class UserRepository {
	
	@Autowired
	private  JdbcTemplate jdbcTemplate;
	
	@Transactional(readOnly=true)
	public List<User> findAll(){
		return jdbcTemplate.query("select * from users", new UserRowMapper());
	}
	
	@Transactional
	public Boolean addUser(User user){
		 return jdbcTemplate.execute("insert into users(name,email) values(?,?)", new PreparedStatementCallback<Boolean>(){
			@Override
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
                ps.setString(1, user.getName());
                ps.setString(2, user.getEmail());
				return ps.executeUpdate() > 0;
			}
		});
	}
	

	class UserRowMapper implements RowMapper<User> {
		@Override
		public User mapRow(ResultSet paramResultSet, int paramInt) throws SQLException {
			User user = new User();
	        user.setId(paramResultSet.getInt("id"));
	        user.setName(paramResultSet.getString("name"));
	        user.setEmail(paramResultSet.getString("email"));
			return user;
		}

	}
}
