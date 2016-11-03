/**
 * 
 */
package com.rajiv.agri.quiz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.ArrayList;
import java.util.List;
import com.rajiv.agri.quiz.bean.Shop;
import com.rajiv.agri.quiz.bean.Student;

/**
 * @author 172661
 * 
 */
@Controller
//@RequestMapping("/company")
public class JSONController {

	@RequestMapping(value = "/company/{name}", method = RequestMethod.GET)
	public @ResponseBody
	Shop getShopInJSON(@PathVariable String name) {

		Shop shop = new Shop();
		shop.setName(name);
		shop.setStaffName(new String[] { "Rajiv", "Sanjeev" });

		return shop;

	}

	@RequestMapping("/student")
	public @ResponseBody
	Student getStudent() {
		return new Student(23, "meghna", "eheee", "meghna@gmail.com","8978767878");
		/*Student std =new Student();
		std.setId(23);
		std.setFirstName("Meghna");
		std.setLastName("Naidu");
		std.setEmailID("meghna@gmail.com");
		std.setMobileNo("+91-8978767878");*/
		//return std;
	}

	@RequestMapping("/studentlist")
	public @ResponseBody
	List<Student> getStudentList() {
		List<Student> studentList = new ArrayList<Student>();
		studentList.add(new Student(23, "Meghna", "Naidu", "meghna@gmail.com",
				"8978767878"));
		studentList.add(new Student(3, "Robert", "Parera", "robert@gmail.com",
				"8978767878"));
		studentList.add(new Student(93, "Andrew", "Strauss",
				"andrew@gmail.com", "8978767878"));
		studentList.add(new Student(239, "Eddy", "Knight", "knight@gmail.com",
				"7978767878"));

  return studentList;
 }
	/*public @ResponseBody  List<Student> getStudentList() { 
		List<Student> studentList = new ArrayList<Student>();
		Student std= new Student();
		for(int i=0;i<5;i++){
			
			std.setId(23);
			std.setFirstName("Meghna");
			std.setLastName("Naidu");
			std.setEmailID("meghna@gmail.com");
			std.setMobileNo("+91-8978767878");
			studentList.add(std);
		}
		
		return studentList;
	}*/
}
