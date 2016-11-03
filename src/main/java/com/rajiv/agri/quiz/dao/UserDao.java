/**
 * 
 */
package com.rajiv.agri.quiz.dao;

import java.util.List;

import javax.sql.DataSource;

import com.rajiv.agri.quiz.bean.User;

/**
 * @author 172661
 *
 */
public interface UserDao {
	 void setDataSource(DataSource ds);

	 void create(String userId, String password,String userType);

	  List<User> select(String userId, String password);

	  List<User> selectAll();

	  void deleteAll();

	  void delete(String userId, String password);

}
