/**
 * 
 */
package com.rajiv.agri.quiz.daoImpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.sql.DataSource;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.jdbc.core.JdbcTemplate;

import com.rajiv.agri.quiz.common.RestAPIConstants;
import com.rajiv.agri.quiz.dao.UserDao;
import com.rajiv.agri.quiz.rowmap.QuizRowMap;
import com.rajiv.agri.quiz.rowmap.UserRowMap;
import com.rajiv.agri.quiz.bean.Question;
import com.rajiv.agri.quiz.bean.User;

/**
 * @author 172661
 * 
 */
public class UserDaoImpl implements UserDao {

	private DataSource dataSource;

	public void setDataSource(DataSource ds) {
		dataSource = ds;
		
	}
	@SuppressWarnings("unchecked")
	public List<Question> createSql(String sqlQuery) {
		JdbcTemplate create = new JdbcTemplate(dataSource);
		//try{
		//create.execute(sqlQuery);
		return create.query(sqlQuery,
				new QuizRowMap());
		
		//}catch(Exception ex){
			//ex.printStackTrace();
		//}
	}
	@SuppressWarnings("unchecked")
	public void executeQuery(String sqlQuery) {
		JdbcTemplate create = new JdbcTemplate(dataSource);
		try{
		create.execute(sqlQuery);
		
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public void uploadQuestion(String Excelfile) throws ClassNotFoundException, SQLException {
		JdbcTemplate upload = new JdbcTemplate(dataSource);

		try {

			// String path=request.getParameter("file");
			String remoteloc = "C:/Users/Rajiv/Downloads/Quiz_Test/";
			FileInputStream file = new FileInputStream(new File(remoteloc + Excelfile));

			// Create Workbook instance holding reference to .xlsx file
			XSSFWorkbook workbook = new XSSFWorkbook(file);

			// Get first/desired sheet from the workbook
			XSSFSheet sheet = workbook.getSheetAt(0);

			// Iterate through each rows one by one
			// Iterator<Row> rowIterator = sheet.iterator();

			Row row;
			for (int i = 1; i <= sheet.getLastRowNum(); i++) {
				row = sheet.getRow(i);

				int id = (int) row.getCell(0).getNumericCellValue();
				String question = row.getCell(1).getStringCellValue();
				String option_1 = row.getCell(2).getStringCellValue();
				String option_2 = row.getCell(3).getStringCellValue();
				String option_3 = row.getCell(4).getStringCellValue();
				String option_4 = row.getCell(5).getStringCellValue();
				String question_type = row.getCell(6).getStringCellValue();
				String answer_value = row.getCell(7).getStringCellValue();
				String course_type = row.getCell(8).getStringCellValue();

				upload.update(
						"INSERT INTO QUESTION_TABLE (QUESTION_ID, QUESTION, OPTION_1,OPTION_2, OPTION_3, OPTION_4,QUESTION_TYPE,ANSWER_VALUE,COURSE_TYPE) VALUES(?,?,?,?,?,?,?,?,?)",
						new Object[] { id, question, option_1, option_2, option_3, option_4, question_type,
								answer_value, course_type });

			}

		} catch (IOException ioe) {
			System.out.println(ioe);
		}
		// Store the Question Excell in the data base ends here

		catch (Exception exception) {
			exception.printStackTrace();
		}

	}
	public void create(String userId, String password,String userType) {
		JdbcTemplate insert = new JdbcTemplate(dataSource);
		try{
		System.out.println("I am in Create Method");
		//insert.execute("CREATE TABLE USER_REG(USER_ID VARCHAR(255),PASSWORD VARCHAR(255))");
		insert.update("INSERT INTO USER_REG (USER_ID, PASSWORD, USER_TYPE) VALUES(?,?,?)",new Object[] { userId, password,userType });
		//insert.execute("show connections");
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public List<User> select(String userId, String password) {
		JdbcTemplate select = new JdbcTemplate(dataSource);
		
		return select
				.query(
						"select  USER_ID, PASSWORD, USER_TYPE from USER_REG where USER_ID = ? AND PASSWORD= ?",
						new Object[] { userId, password },
						new UserRowMap());
		
	}

	@SuppressWarnings("unchecked")
	public List<User> selectAll() {
		JdbcTemplate select = new JdbcTemplate(dataSource);
		return select.query("select USER_ID, PASSWORD from USER_REG",
				new UserRowMap());
	}

	public void deleteAll() {
		JdbcTemplate delete = new JdbcTemplate(dataSource);
		delete.update("DELETE from USER_REG");
	}

	public void delete(String userId, String password) {
		JdbcTemplate delete = new JdbcTemplate(dataSource);
		delete.update("DELETE from USER_REG where USER_ID= ? AND PASSWORD = ?",
				new Object[] { userId, password });
	}

}
