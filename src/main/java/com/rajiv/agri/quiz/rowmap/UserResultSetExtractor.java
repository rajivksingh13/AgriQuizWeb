package com.rajiv.agri.quiz.rowmap;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.ResultSetExtractor;

import com.rajiv.agri.quiz.bean.*;

/**
 * @author 172661
 *
 */
public class UserResultSetExtractor implements ResultSetExtractor {

	public Object extractData(ResultSet rs) throws SQLException {
		User user = new User();
		user.setUserID(rs.getString(1));
		user.setPassword(rs.getString(2));
		user.setUserType(rs.getString(3));
		System.out.println("User in UserResultSetExtractor:::" + user.getUserID().toString());
		System.out.println("Pwd in UserResultSetExtractor:::" + user.getPassword().toString());
		System.out.println("Pwd in UserResultSetExtractor:::" + user.getUserType().toString());

		return user;
	}

}
