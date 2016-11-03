/**
 * 
 */
package com.rajiv.agri.quiz.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.rajiv.agri.quiz.common.RestAPIConstants;

/**
 * @author 172661
 *
 */
@Controller
//@RequestMapping("/movie")
public class MovieController {

	@RequestMapping(value = "/movie/{name}", method = RequestMethod.GET)
	public ModelAndView getMovie(@PathVariable String name) {
		ModelAndView mv = new ModelAndView();
		//model.addAttribute("movie", name);
		mv.addObject("movie", name);
		mv.setViewName("movie");
		return mv;

	}
	
}
