	package ruay.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ruay.dao.TbMemberDAO;
import ruay.model.JsonResponseModel;
import ruay.model.TbMemberModel;

@Controller
public class HomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/html;charset=UTF-8");

		System.out.println("Home Page Requested");
		ModelAndView model = new ModelAndView("home"); // home.jsp
		try {
			
			return model;
		} catch (Exception e) {
			//model.addObject("exception", e);
			//model.addObject("url", request.getRequestURL());
			//model.setViewName("error");
		}
		return model;
	}
	
	@RequestMapping(value = "/about", method = RequestMethod.GET)
	public ModelAndView about(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/html;charset=UTF-8");

		System.out.println("About Page Requested");
		ModelAndView model = new ModelAndView();
		try {
			
			return model;
		} catch (Exception e) {
			//model.addObject("exception", e);
			//model.addObject("url", request.getRequestURL());
			//model.setViewName("error");
		}
		return model;
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@ResponseBody
	public JsonResponseModel register(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/html;charset=UTF-8");

		System.out.println("Register Page Requested");
		JsonResponseModel json = new JsonResponseModel();
		try {
			String fname = request.getParameter("fname");
			String lname = request.getParameter("lname");
			String gender = request.getParameter("gender");
			
			System.out.println(fname + ", " + lname + ", " + gender);
			
			TbMemberModel tbmModel = new TbMemberModel(fname, fname, gender);
			TbMemberDAO tbmDAO = new TbMemberDAO();
			int tbmId = tbmDAO.Add(tbmModel);
			
			System.out.println("Inserted ID: " + tbmId);
			
			json.setStatus("1");
			json.setResult("success");
			
			return json;
		} catch (Exception e) {
			//model.addObject("exception", e);
			//model.addObject("url", request.getRequestURL());
			//model.setViewName("error");
		}
		return json;
	}
}
