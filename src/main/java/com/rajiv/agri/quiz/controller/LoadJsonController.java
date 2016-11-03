/**
Rajiv Commit */
package com.rajiv.agri.quiz.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.expression.ParseException; //import org.springframework.core.io.ClassPathResource;
//import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rajiv.agri.quiz.rowmap.UserResultSetExtractor;
//import com.test.rajiv.utils.CommonUtils;
import com.rajiv.agri.quiz.bean.Question;
import com.rajiv.agri.quiz.bean.User;
import com.rajiv.agri.quiz.common.RestAPIConstants;
import com.rajiv.agri.quiz.dao.UserDao;
import com.rajiv.agri.quiz.daoImpl.UserDaoImpl;
 
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author 172661 This Controller Loads the JSON Response to View
 */
@Controller
public class LoadJsonController {
	private static final String STR_CLASS_NAME = "LoadJsonController";
	final static Logger logger = LoggerFactory
			.getLogger(LoadJsonController.class);

	// @Value(RestAPIConstants.LOAD_JSON)
	// Resource homepageJSON;
	@Autowired
	UserDaoImpl userdao;
	UserResultSetExtractor rs = new UserResultSetExtractor();
	User myuser;
	boolean isLogedIn=false;
	//PreparedStatement pstm = null ;
	/**
	 * 
	 * @param req
	 * @param res
	 * @return
	 * @throws Exception
	 * 
	 */
	public LoadJsonController() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * Code Starts for Online Quize Application here
	 * 
	 * 
	 */
	@RequestMapping(value = RestAPIConstants.QUIZ_HOME)
	public ModelAndView loadQuizHome(HttpServletRequest request,
			HttpServletResponse response,HttpSession session) throws Exception {

		final String strMethodName = RestAPIConstants.LOAD_QUIZ_HOME;
		ModelAndView mv = new ModelAndView();
		//JSONParser parser = new JSONParser();
		session=request.getSession(false);
		
		try {
			if (session.getAttribute("UserID") != null && isLogedIn==true) {
				mv.addObject("isLogedIn",isLogedIn);
				mv.setViewName(RestAPIConstants.QUIZ_PAGE_VIEW);
			} else {
				mv.addObject("isLogedIn",isLogedIn);
				mv.setViewName(RestAPIConstants.QUIZ_HOME_LANDING);
			}
		} catch (Exception exception) {
			exception.printStackTrace();
			
			mv.setViewName(RestAPIConstants.QUIZ_HOME_ERROR);
		}
		// Log4JManager.writeToTraceLog(OpenRedesignConstants.LOGGER_TYPE_INFO,
		// STR_CLASS_NAME, strMethodName, "EXIT");
		return mv;
	}
	
	@RequestMapping(value = RestAPIConstants.USER_LOGOUT)
	public ModelAndView userQuizLogout(HttpServletRequest request,
			HttpServletResponse response,HttpSession session) throws Exception {

		final String strMethodName = RestAPIConstants.USER_QUIZ_LOGOUT;
		ModelAndView mv = new ModelAndView();
		session=request.getSession(false);
		session.invalidate();
		isLogedIn=false;
		try {
			mv.addObject("isLogedIn",isLogedIn);
			mv.setViewName(RestAPIConstants.QUIZ_HOME_LANDING);
         
		} catch (Exception exception) {
			exception.printStackTrace();
			
			mv.setViewName(RestAPIConstants.QUIZ_HOME_ERROR);
		}
		// Log4JManager.writeToTraceLog(OpenRedesignConstants.LOGGER_TYPE_INFO,
		// STR_CLASS_NAME, strMethodName, "EXIT");
		return mv;
	}

	/*@RequestMapping(value = RestAPIConstants.QUIZ_LOGIN)
	public ModelAndView loadLoginQuiz(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		final String strMethodName = RestAPIConstants.LOAD_QUIZ_LOGIN;
		ModelAndView mv = new ModelAndView();
		JSONParser parser = new JSONParser();

		try {

			try {

				Object obj = parser
						.parse(new FileReader(
								"D:/OpenPhase2/RestAPIWeb/src/main/resources/json/userReg.json"));
				String userID = request.getParameter("uID");
				String pwd = request.getParameter("pawd");
				JSONObject jsonObject = (JSONObject) obj;
				System.out.println("jsonobject" + jsonObject.get("userid"));
				if ((userID.equalsIgnoreCase((String) jsonObject.get("userid")))
						&& (pwd.equalsIgnoreCase((String) jsonObject
								.get("password")))) {
					mv.setViewName(RestAPIConstants.QUIZ_PAGE);
				}
			}

			catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ParseException e) {
				e.printStackTrace();
			}//

		} catch (Exception exception) {
			exception.printStackTrace();
			// Log4JManager.writeToTraceLog(OpenRedesignConstants.
			// LOGGER_TYPE_ERROR, STR_CLASS_NAME, strMethodName,
			// "Redirecting to the fallback page, since the Exception occured["
			// + exception.getMessage() + "]");
			// response.sendRedirect(
			// "http://localhost:9080/home/fallback/ak/index-a.html");
			mv.setViewName(RestAPIConstants.QUIZ_HOME_ERROR);
		}
		// Log4JManager.writeToTraceLog(OpenRedesignConstants.LOGGER_TYPE_INFO,
		// STR_CLASS_NAME, strMethodName, "EXIT");
		return mv;
	}*/
	
	@RequestMapping(value = RestAPIConstants.QUIZ_LOGIN)
	public ModelAndView loadLoginQuizDB(HttpServletRequest request,
			HttpServletResponse response,HttpSession session) throws Exception {

		final String strMethodName = RestAPIConstants.LOAD_QUIZ_LOGIN;
		ModelAndView mv = new ModelAndView();
		//HttpSession session = request.getSession();
		session = request.getSession();
		//session.invalidate();
		try {
			String userID = request.getParameter("uID");
			String pwd = request.getParameter("pawd");
			String uID = "";
			String paswd = "";
			String userType = "";
			List<User> list = userdao.select(userID, pwd);
			// List<User> list=userdao.selectAll();
			if (userID.equalsIgnoreCase("") && pwd.equalsIgnoreCase("")) {
				mv
						.addObject(
								"errorMsg",
								"UserID and Passowd Value Cann't be Empty !!! Please Enter Valid UserID and Password");
				mv.setViewName(RestAPIConstants.QUIZ_HOME_LANDING);
			}
			
			if (!(userID.equalsIgnoreCase("")) && !(pwd.equalsIgnoreCase(""))) {
				
				for (User myUser : list) {

					uID = myUser.getUserID().toString();
					paswd = myUser.getPassword().toString();
					userType = myUser.getUserType().toString();
				}
				if (userID.equalsIgnoreCase(uID) && pwd.equalsIgnoreCase(paswd)) {
					session.setAttribute("UserID", userID);
					session.setAttribute("Password", pwd);
					session.setMaxInactiveInterval(30);
					isLogedIn=true;
					mv.addObject("isLogedIn",isLogedIn);
					mv.addObject("UserID", userID);
					mv.setViewName(RestAPIConstants.QUIZ_PAGE_VIEW);
					
				} else {
					mv.addObject("errorMsg1",
							"Please Enter Valid UserID and Password");
					mv.setViewName(RestAPIConstants.QUIZ_HOME_LANDING);
				}
			}
			
			
			
		} catch (Exception exception) {
			exception.printStackTrace();
			mv.setViewName(RestAPIConstants.QUIZ_HOME_ERROR);
		}

		return mv;
	}
	@RequestMapping(value = RestAPIConstants.QUIZ_START ,method = RequestMethod.GET)
	public ModelAndView loadQuizStart(HttpServletRequest request,
			HttpServletResponse response, @PathVariable String course_type) throws Exception {

		final String strMethodName = RestAPIConstants.LOAD_QUIZ_START;
		ModelAndView mv = new ModelAndView();
		//HttpSession session = request.getSession();

		try {
			//String course_type = request.getParameter("course");
           //System.out.println("course_type"+course_type);
			mv.addObject("course_type",course_type);
			mv.setViewName(RestAPIConstants.QUIZ_PAGE);

		} catch (Exception exception) {
			exception.printStackTrace();
			mv.setViewName(RestAPIConstants.QUIZ_HOME_ERROR);
		}

		return mv;
	}

	@RequestMapping(value = RestAPIConstants.QUIZ_REG)
	public ModelAndView loadQuizReg(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		final String strMethodName = RestAPIConstants.LOAD_QUIZ_REG;
		ModelAndView mv = new ModelAndView();

		try {

			mv.setViewName(RestAPIConstants.QUIZ_REG_LANDING);

			// This code is to test Error Page
			// int i=10;
			// int j=i/0;
		} catch (Exception exception) {
			// Log4JManager.writeToTraceLog(OpenRedesignConstants.
			// LOGGER_TYPE_ERROR, STR_CLASS_NAME, strMethodName,
			// "Redirecting to the fallback page, since the Exception occured["
			// + exception.getMessage() + "]");
			// response.sendRedirect(
			// "http://localhost:9080/home/fallback/ak/index-a.html");
			mv.setViewName(RestAPIConstants.QUIZ_HOME_ERROR);
		}
		// Log4JManager.writeToTraceLog(OpenRedesignConstants.LOGGER_TYPE_INFO,
		// STR_CLASS_NAME, strMethodName, "EXIT");
		return mv;
	}
	/*@SuppressWarnings("unchecked")
	@RequestMapping(value = RestAPIConstants.START_QUIZ)
	public ModelAndView startQuiz(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		final String strMethodName = RestAPIConstants.LOAD_QUIZ_REG;
		ModelAndView mv = new ModelAndView();
		
		try {
			String sqlQuery = "Select * from QUESTION_TABLE";
			List<Question> list=userdao.createSql(sqlQuery);		
			mv.addObject("list", list);
			mv.setViewName(RestAPIConstants.QUIZ_PAGE_VIEW);

		} catch (Exception exception) {

			mv.setViewName(RestAPIConstants.QUIZ_HOME_ERROR);
		}

		return mv;
	}*/
	// Through Response Body to get JSON as a Response Starts
	@SuppressWarnings("unchecked")
	@RequestMapping(value = RestAPIConstants.START_QUIZ,method = RequestMethod.GET)
	public @ResponseBody List<Question> startQuiz(HttpServletRequest request,
			HttpServletResponse response,@PathVariable 
            String course_type) throws Exception {

		final String strMethodName = RestAPIConstants.LOAD_QUIZ_REG;
		
		//String sqlQuery = "Select * from QUESTION_TABLE";		
		//EhCacheCacheManager cacheManager = new EhCacheCacheManager();
		//Cache cache = cacheManager.getCache("agriQuizJsonCache");			
		//Element value = (Element) cache.get("questionID");
		//ModelAndView mv = new ModelAndView();
		//ObjectMapper mapper = new ObjectMapper();
		try {
			System.out.println("Course Type Is:"+course_type);
			String sqlQuery = "Select * from QUESTION_TABLE where COURSE_TYPE="+"'"+course_type+"'";
			List<Question> list=userdao.createSql(sqlQuery);
			
			//mv.addObject("list", list);
			//mv.setViewName(RestAPIConstants.QUIZ_PAGE_VIEW);
			System.out.println("The Question Respose is in JSON:"+list.toString());
			return list;
		} catch (Exception exception) {
			exception.printStackTrace();
			//mv.setViewName(RestAPIConstants.QUIZ_HOME_ERROR);
		}finally {
            System.out.println("The Question Respose is in JSON:");
        }
		return null;
		
	}
		// Through Response Body to get JSON as a Response Ends
	/*@RequestMapping(value = RestAPIConstants.SUBMIT_QUIZ)
	public ModelAndView submitQuiz(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		final String strMethodName = RestAPIConstants.LOAD_QUIZ_REG;
		ModelAndView mv = new ModelAndView();
		//Question qs = new Question();
		try {
			int count=0;
			String sqlQuery = "Select * from QUESTION_TABLE";	
			List<Question> listdb=userdao.createSql(sqlQuery);
			String[] option= request.getParameterValues("Option");
			List<String> list= new ArrayList<String>();
			if(option !=null){
				for(int i=0;i<option.length;i++){
					System.out.println("Option here is:::"+ option[i]);
					list.add(option[i]);
					if(listdb.get(i).getAnswer_value().equals(list.get(i))){
						count++;
					}
				}
				
			}
			
			mv.addObject("option", count);
			mv.setViewName(RestAPIConstants.RESULT_PAGE_VIEW);

		} catch (Exception exception) {
			exception.printStackTrace();
			mv.setViewName(RestAPIConstants.QUIZ_HOME_ERROR);
		}

		return mv;
	}*/
	/*@SuppressWarnings("unchecked")
	@RequestMapping(value = RestAPIConstants.QUIZ_SUCS_REG)
	public ModelAndView loadsucsReg(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		final String strMethodName = RestAPIConstants.LOAD_SUCS_REG;
		ModelAndView mv = new ModelAndView();
		JSONObject obj = new JSONObject();
		 //JSONArray list = new JSONArray();
		try {

			String userID = request.getParameter("uID");
			String pwd = request.getParameter("pawd");
			//list.add(0, userID);
			//list.add(1, pwd);
			obj.put("userid", userID);
			obj.put("password", pwd);
			//obj.put("userData", list);
			 //list.add(obj);
			try {

				FileWriter file = new FileWriter(
						"D:/OpenPhase2/RestAPIWeb/src/main/resources/json/userReg.json");
    			 file.write(obj.toJSONString());
				 file.flush();
				 file.close();
				 

			} catch (IOException e) {
				e.printStackTrace();
			}
			mv.setViewName(RestAPIConstants.QUIZ_REG_SUCCESS);
			// This code is to test Error Page
			// int i=10;
			// int j=i/0;
		} catch (Exception exception) {
			// Log4JManager.writeToTraceLog(OpenRedesignConstants.
			// LOGGER_TYPE_ERROR, STR_CLASS_NAME, strMethodName,
			// "Redirecting to the fallback page, since the Exception occured["
			// + exception.getMessage() + "]");
			// response.sendRedirect(
			// "http://localhost:9080/home/fallback/ak/index-a.html");
			mv.setViewName(RestAPIConstants.QUIZ_HOME_ERROR);
		}
		// Log4JManager.writeToTraceLog(OpenRedesignConstants.LOGGER_TYPE_INFO,
		// STR_CLASS_NAME, strMethodName, "EXIT");
		return mv;
	}*/
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = RestAPIConstants.QUIZ_SUCS_REG)
	public ModelAndView loadsucsRegDB(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		final String strMethodName = RestAPIConstants.LOAD_SUCS_REG;
		ModelAndView mv = new ModelAndView();
		
		try {

			String userID = request.getParameter("uID");
			String pwd = request.getParameter("pawd");
			String userType = request.getParameter("UserType");
			
			userdao.create(userID, pwd,userType);
			mv.setViewName(RestAPIConstants.QUIZ_REG_SUCCESS);
			
		} catch (Exception exception) {
			exception.printStackTrace();
			mv.setViewName(RestAPIConstants.QUIZ_HOME_ERROR);
		}
		
		return mv;
	}
	
	
	/*@SuppressWarnings("unchecked")
	@RequestMapping(value = RestAPIConstants.UPLOAD)
	public ModelAndView uploadfile(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		final String strMethodName = RestAPIConstants.LOAD_SUCS_REG;
		FileWriter filejson = new FileWriter(
		"D:/OpenPhase2/RestAPIWeb/src/main/resources/json/quiz.json");
		ModelAndView mv = new ModelAndView();
		//JSONObject obj = new JSONObject();
		//JSONArray list = new JSONArray();
		try {
			
			String path=request.getParameter("file");
			
			userdao.uploadQuestion(path);
			//String remoteloc="C:/Users/172661/Desktop/";
			//FileInputStream file = new FileInputStream(new File(remoteloc+path));
			 
            //Create Workbook instance holding reference to .xlsx file
           // XSSFWorkbook workbook = new XSSFWorkbook(file);
 
            //Get first/desired sheet from the workbook
          //  XSSFSheet sheet = workbook.getSheetAt(0);
 
            //Iterate through each rows one by one
          //  Iterator<Row> rowIterator = sheet.iterator();
          //  Row row;      
            while (rowIterator.hasNext()) 
            {
                Row row = rowIterator.next();
                //For each row, iterate through all the columns
                Iterator<Cell> cellIterator = row.cellIterator();
                 while (cellIterator.hasNext()) 
                {
                    Cell cell = cellIterator.next();
                    //Check the cell type and format accordingly
                    
                    switch (cell.getCellType()) 
                    {
                        case Cell.CELL_TYPE_NUMERIC:
                            System.out.print("This is Zeroth row");
                           
                            break;
                        case Cell.CELL_TYPE_STRING:
                            //System.out.print(cell.getStringCellValue() + "t");
                            list.add(cell.getStringCellValue());
                            obj.put("question",list);
                            
                            break;
                         }
                }
                 
                filejson.write(obj.toJSONString());
            }
             
            file.close();
           
            
	        filejson.flush();
			filejson.close();
            
            //Store the Question Excell in the database starts here
            for(int i=1; i<=sheet.getLastRowNum(); i++){
                row = sheet.getRow(i);
                int id = (int) row.getCell(0).getNumericCellValue();
                String question = row.getCell(1).getStringCellValue();
                String option_1 = row.getCell(2).getStringCellValue();
                String option_2 = row.getCell(3).getStringCellValue();
                String option_3 = row.getCell(4).getStringCellValue();
                String option_4 = row.getCell(5).getStringCellValue();
                String sql = "INSERT INTO tablename VALUES('"+id+"','"+question+"','"+option_1+"','"+option_2+"','"+option_3+"','"+option_4+"')";
                pstm = (PreparedStatement) con.prepareStatement(sql);
                pstm.execute();
                System.out.println("Import rows "+i);
            }
            //con.commit();
            pstm.close();
           // con.close();
            //input.close();
            System.out.println("Success import excel to mysql table");
		
        }catch(ClassNotFoundException e){
            System.out.println(e);
        }catch(SQLException ex){
            System.out.println(ex);
        }catch(IOException ioe){
            System.out.println(ioe);
        }
        //Store the Question Excell in the data base ends here
		}			
		 catch (Exception exception) {
			exception.printStackTrace();
			mv.setViewName(RestAPIConstants.QUIZ_HOME_ERROR);
		}
		
		return mv;
	}*/
}
