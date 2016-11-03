/**
 * 
 */
package com.rajiv.agri.quiz.rowmap;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

/**
 * @author 172661
 *
 */
public class UserRowMap implements RowMapper {

	  public Object mapRow(ResultSet rs, int line) throws SQLException {
		  UserResultSetExtractor extractor = new UserResultSetExtractor();
	    return extractor.extractData(rs);
	  }

}
