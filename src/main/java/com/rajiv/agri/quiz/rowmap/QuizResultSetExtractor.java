/**
 * 
 */
package com.rajiv.agri.quiz.rowmap;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.ResultSetExtractor;

import com.rajiv.agri.quiz.bean.*;

/**
 * @author 172661
 *
 */
public class QuizResultSetExtractor implements ResultSetExtractor {

	public Object extractData(ResultSet rs) throws SQLException {
		Question question = new Question();
		question.setQuestionID((Integer.parseInt(rs.getString(1))));
		question.setQuestion(rs.getString(2));
		question.setOption_1(rs.getString(3));
		question.setOption_2(rs.getString(4));
		question.setOption_3(rs.getString(5));
		question.setOption_4(rs.getString(6));
		question.setQuestion_type(rs.getString(7));
		question.setAnswer_value(rs.getString(8));
		question.setCourse_type(rs.getString(9));

		System.out.println("User in UserResultSetExtractor:::" + question.getQuestionID());
		System.out.println("User in UserResultSetExtractor:::" + question.getQuestion().toString());
		System.out.println("User in UserResultSetExtractor:::" + question.getOption_1().toString());
		System.out.println("User in UserResultSetExtractor:::" + question.getOption_2().toString());
		System.out.println("User in UserResultSetExtractor:::" + question.getOption_3().toString());
		System.out.println("User in UserResultSetExtractor:::" + question.getOption_4().toString());
		System.out.println("User in UserResultSetExtractor:::" + question.getQuestion_type().toString());
		System.out.println("User in UserResultSetExtractor:::" + question.getAnswer_value().toString());
		System.out.println("User in UserResultSetExtractor:::"+question.getCourse_type().toString());
		return question;
	}

}
