/**
 * 
 */
package com.rajiv.agri.quiz.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.rajiv.agri.quiz.common.RestAPIConstants;
import com.rajiv.agri.quiz.daoImpl.UserDaoImpl;
import com.rajiv.agri.quiz.rowmap.UserResultSetExtractor;
import com.rajiv.agri.quiz.bean.Question;
import com.rajiv.agri.quiz.bean.User;

/**
 * @author 172661
 *
 */
@Controller
public class AgriQuizAdminController {
	private static final String STR_CLASS_NAME = "AgriQuizAdminController";
	//final static Logger logger = LoggerFactory
			//.getLogger(LoadJsonController.class);
	
	@Autowired
	UserDaoImpl userdao;
	UserResultSetExtractor rs = new UserResultSetExtractor();
	User myuser;
	boolean isLogedIn=false;
	/**
	 * 
	 * @param req
	 * @param res
	 * @return
	 * @throws Exception
	 * 
	 */
	public AgriQuizAdminController() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Code Starts for Online Quize Application here
	 * 
	 * 
	 */
	@RequestMapping(value = RestAPIConstants.QUIZ_HOME_ADMIN)
	public ModelAndView adminQuizHome(HttpServletRequest request,
			HttpServletResponse response,HttpSession session) throws Exception {

		final String strMethodName = RestAPIConstants.ADMIN_QUIZ_HOME;
		ModelAndView mv = new ModelAndView();
		session=request.getSession(false);
		
		try {
			if (session.getAttribute("UserID") != null && isLogedIn==true) {
				mv.addObject("isLogedIn",isLogedIn);
            	//mv.setViewName(RestAPIConstants.ADMIN_HOME_LANDING);
            	mv.setViewName(RestAPIConstants.ADMIN_QUIZ_PAGE_VIEW);
           }else {
        	   mv.addObject("isLogedIn",isLogedIn);
			//mv.setViewName(RestAPIConstants.ADMIN_PAGE);
			mv.setViewName(RestAPIConstants.ADMIN_HOME_LANDING);
           }
		} catch (Exception exception) {
			exception.printStackTrace();
			
			mv.setViewName(RestAPIConstants.QUIZ_HOME_ERROR);
		}
		// Log4JManager.writeToTraceLog(OpenRedesignConstants.LOGGER_TYPE_INFO,
		// STR_CLASS_NAME, strMethodName, "EXIT");
		return mv;
	}
	
	@RequestMapping(value = RestAPIConstants.ADMIN_LOGOUT)
	public ModelAndView adminQuizLogout(HttpServletRequest request,
			HttpServletResponse response,HttpSession session) throws Exception {

		final String strMethodName = RestAPIConstants.ADMIN_QUIZ_LOGOUT;
		ModelAndView mv = new ModelAndView();
		session=request.getSession(false);
		session.invalidate();
		isLogedIn=false;
		try {
			mv.addObject("isLogedIn",isLogedIn);
			mv.setViewName(RestAPIConstants.ADMIN_HOME_LANDING);
         
		} catch (Exception exception) {
			exception.printStackTrace();
			
			mv.setViewName(RestAPIConstants.QUIZ_HOME_ERROR);
		}
		// Log4JManager.writeToTraceLog(OpenRedesignConstants.LOGGER_TYPE_INFO,
		// STR_CLASS_NAME, strMethodName, "EXIT");
		return mv;
	}
	
	@RequestMapping(value = RestAPIConstants.ADMIN_LOGIN)
	public ModelAndView adminLoginQuizDB(HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {

		final String strMethodName = RestAPIConstants.ADMIN_QUIZ_LOGIN;
		ModelAndView mv = new ModelAndView();
		// HttpSession session = request.getSession();
		session = request.getSession();
		// session.invalidate();
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
				mv.setViewName(RestAPIConstants.ADMIN_HOME_LANDING);
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
					// mv.addObject("UserType", userType);
					if (userType.equalsIgnoreCase("admin")) {
						mv.setViewName(RestAPIConstants.ADMIN_QUIZ_PAGE_VIEW);
					} else if (userType.equalsIgnoreCase("Student")) {
						mv.setViewName(RestAPIConstants.QUIZ_PAGE_VIEW);
					}
				} else {
					mv.addObject("errorMsg1",
							"Please Enter Valid UserID and Password");
					mv.setViewName(RestAPIConstants.ADMIN_HOME_LANDING);
				}
			}

		} catch (Exception exception) {
			exception.printStackTrace();
			mv.setViewName(RestAPIConstants.QUIZ_HOME_ERROR);
		}

		return mv;
	}
	
	@RequestMapping(value = RestAPIConstants.ADMIN_REG)
	public ModelAndView loadAdminReg(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		final String strMethodName = RestAPIConstants.LOAD_ADMIN_REG;
		ModelAndView mv = new ModelAndView();

		try {

			mv.setViewName(RestAPIConstants.ADMIN_REG_LANDING);

		} catch (Exception exception) {
			// Log4JManager.writeToTraceLog(OpenRedesignConstants.
			// LOGGER_TYPE_ERROR, STR_CLASS_NAME, strMethodName,
			// "Redirecting to the fallback page, since the Exception occured["
			// + exception.getMessage() + "]");
			// response.sendRedirect(
			// "http://localhost:9080/home/fallback/ak/index-a.html");
			exception.printStackTrace();
			mv.setViewName(RestAPIConstants.QUIZ_HOME_ERROR);
		}
		// Log4JManager.writeToTraceLog(OpenRedesignConstants.LOGGER_TYPE_INFO,
		// STR_CLASS_NAME, strMethodName, "EXIT");
		return mv;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = RestAPIConstants.Execute_QUERY)
	public ModelAndView createTable(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		final String strMethodName = RestAPIConstants.LOAD_SUCS_REG;
		ModelAndView mv = new ModelAndView();

		try {
			mv.setViewName(RestAPIConstants.Execute_QUERY_VIEW);

		} catch (Exception exception) {
			exception.printStackTrace();
			mv.setViewName(RestAPIConstants.Execute_QUERY_ERROR_VIEW);
		}

		return mv;
	}
	@SuppressWarnings("unchecked")
	@RequestMapping(value = RestAPIConstants.Execute_QUERY_PAGE)
	public ModelAndView createTablePage(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		final String strMethodName = RestAPIConstants.LOAD_SUCS_REG;
		ModelAndView mv = new ModelAndView();
		
		try {
			String executeQuery = request.getParameter("tabCreate");
			userdao.executeQuery(executeQuery);
			mv.addObject("executeQuery", executeQuery);
			mv.setViewName(RestAPIConstants.Execute_QUERY_SUCC);

		} catch (Exception exception) {
			exception.printStackTrace();
			mv.setViewName(RestAPIConstants.Execute_QUERY_ERROR_VIEW);
		}

		return mv;
	}
	
	/*@SuppressWarnings("unchecked")
	@RequestMapping(value = RestAPIConstants.UPLOAD)
	public ModelAndView uploadfile(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		final String strMethodName = RestAPIConstants.LOAD_SUCS_REG;
		
		ModelAndView mv = new ModelAndView();

		try {

			String path = request.getParameter("file");
			userdao.uploadQuestion(path);
			mv.setViewName(RestAPIConstants.QUIZ_REG_SUCCESS);
		} catch (Exception exception) {
			exception.printStackTrace();
			mv.setViewName(RestAPIConstants.QUIZ_HOME_ERROR);
		}

		return mv;
	} 
*/	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = RestAPIConstants.UPLOAD, method = RequestMethod.POST)
	public @ResponseBody String uploadfile(HttpServletRequest request,
			HttpServletResponse response,@RequestParam("name") String fileName,@RequestParam("file") MultipartFile file) throws Exception {

		final String strMethodName = RestAPIConstants.LOAD_SUCS_REG;
		
		ModelAndView mv = new ModelAndView();

		try {

			
			String path="";
			
			// Starts
			if (!file.isEmpty()) {
				byte[] bytes = file.getBytes();
				String rootPath = System.getProperty("catalina.home");
				File dir = new File(rootPath + File.separator + "tmpFiles");
				if (!dir.exists())
					dir.mkdirs();
				// Create the file on server
				File serverFile = new File(dir.getAbsolutePath()
						+ File.separator + fileName);
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();

				System.out.println("Server File Location="
						+ serverFile.getAbsolutePath());
				path=serverFile.getAbsolutePath();	
			}
			userdao.uploadQuestion(path);
			
		} catch (Exception exception) {
			exception.printStackTrace();
			mv.setViewName(RestAPIConstants.QUIZ_HOME_ERROR);
		}

		return null;
	}
	/*@RequestMapping(value = RestAPIConstants.ADMIN_START_QUIZ)
	public ModelAndView adminLoadQuiz(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		final String strMethodName = RestAPIConstants.ADMIN_LOAD_QUIZ;
		ModelAndView mv = new ModelAndView();
		//Question qs = new Question();
		try {
			String sqlQuery = "Select * from QUESTION_TABLE";
			List<Question> list=userdao.createSql(sqlQuery);
			mv.addObject("list", list);
			mv.setViewName(RestAPIConstants.ADMIN_QUIZ_PAGE_VIEW);

		} catch (Exception exception) {

			mv.setViewName(RestAPIConstants.QUIZ_HOME_ERROR);
		}

		return mv;
	}*/
	
	// Through Response Body to get JSON as a Response Starts
		@SuppressWarnings("unchecked")
		@RequestMapping(value = RestAPIConstants.ADMIN_START_QUIZ)
		public @ResponseBody List<Question> adminLoadQuiz(HttpServletRequest request,
				HttpServletResponse response,@PathVariable String course_type) throws Exception {

			final String strMethodName = RestAPIConstants.ADMIN_LOAD_QUIZ;
			ModelAndView mv = new ModelAndView();
			
			try {
				mv.addObject("course_type",course_type);
				mv.setViewName(RestAPIConstants.ADMIN_PAGE);
				//String sqlQuery = "Select * from QUESTION_TABLE";
				//List<Question> list=userdao.createSql(sqlQuery);
				//return list;
			} catch (Exception exception) {
				exception.printStackTrace();
				mv.setViewName(RestAPIConstants.QUIZ_HOME_ERROR);
			}finally {
	            System.out.println("The Question Respose is in JSON:");
	        }
			return (List<Question>) mv;
			
		}
		
		@SuppressWarnings("unchecked")
		@RequestMapping(value = RestAPIConstants.START_QUIZ_ADMIN,method = RequestMethod.GET)
		public @ResponseBody List<Question> startQuiz(HttpServletRequest request,
				HttpServletResponse response,@PathVariable 
	            String course_type) throws Exception {

			final String strMethodName = RestAPIConstants.LOAD_QUIZ_REG;
			
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
	/*@RequestMapping(value = RestAPIConstants.ADMIN_SUBMIT_QUIZ)
	public ModelAndView adminSubmitQuiz(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		final String strMethodName = RestAPIConstants.ADMIN_SUBMIT;
		ModelAndView mv = new ModelAndView();
		//Question qs = new Question();
		//String[] option=null;
		//List<String> option= new ArrayList<String>();
		try {
			int count=0;
            String sqlQuery = "Select * from QUESTION_TABLE";    
            List<Question> listdb=userdao.createSql(sqlQuery);
            List<String> option =new ArrayList();
            //Try To Get Options Starts
            System.out.println("listdb.size() is :::"+listdb.size());
            for(int j=1;j<listdb.size()+1;j++){
                  String option1= request.getParameter("Option_"+j);         
                  String str="Option_"+j;
                  System.out.println("str is"+str);
                  System.out.println("option1 is"+option1);
                  option.add(j-1, option1);
                  }
            //Try To get Options Ends
          //  List<String[]> list= new ArrayList<String[]>();
            if(option !=null){
                  System.out.println("option.size() is :::"+option.size());
                  for(int i=0;i<option.size();i++){
                        System.out.println("Option here is:::"+option.get(i).toString());
                       
                       
                        if(listdb.get(i).getAnswer_value().toString().equals(option.get(i).toString())){
                              count++;
                        }
                  }
                 
            }
			
			mv.addObject("option", count);
			mv.setViewName(RestAPIConstants.ADMIN_RESULT_PAGE_VIEW);

		} catch (Exception exception) {
			exception.printStackTrace();
			mv.setViewName(RestAPIConstants.QUIZ_HOME_ERROR);
		}

		return mv;
	}*/
}
