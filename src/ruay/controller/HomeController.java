	package ruay.controller;

import java.util.ArrayList;

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
			TbMemberDAO tbmDAO = new TbMemberDAO();
			ArrayList<TbMemberModel> tbmMemberList = tbmDAO.FindAll();
			System.out.println("size: "+tbmMemberList.size());
			
			for (int i = 0; i < tbmMemberList.size(); i++) {
				TbMemberModel tbmModel = tbmMemberList.get(i);
				System.out.println(tbmModel.toString());
			}
			
			request.setAttribute("tbmMemberList", tbmMemberList);
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
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/html;charset=UTF-8");

		System.out.println("Login Page Requested");
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
	
	@RequestMapping(value = "/login_auth", method = RequestMethod.POST)
	@ResponseBody
	public JsonResponseModel login_auth(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/html;charset=UTF-8");

		System.out.println("Login Auth Page Requested");
		JsonResponseModel json = new JsonResponseModel();
		try {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			System.out.println(username + ", " + password);
			//DAO here
			TbMemberDAO tbmDAO = new TbMemberDAO();
			//check username in database isEmpty
			TbMemberModel tbmModelCheck = tbmDAO.FindByLoginCheck(username);
			if(tbmModelCheck.getId() <= 0) {
				System.out.println("User not store in database!");
				json.setStatus("-1");
				json.setResult("fail");
			}
			
			//check username and password in database
			TbMemberModel tbmModel = tbmDAO.FindByLogin(username, password);
			if(tbmModel.getId() > 0) {
				System.out.println("User and password loged sucessfully!");
				session.setAttribute("memberLogin", tbmModel); //set login session
				
				json.setStatus("1");
				json.setResult("success");
			} else {
				System.out.println("User password not correct!");
				json.setStatus("0");
				json.setResult("fail");
			}
			
			return json;
		} catch (Exception e) {
			//model.addObject("exception", e);
			//model.addObject("url", request.getRequestURL());
			//model.setViewName("error");
		}
		return json;
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
	
	@RequestMapping(value = "/update_member", method = RequestMethod.GET)
	public ModelAndView update_member(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/html;charset=UTF-8");

		System.out.println("About Page Requested");
		ModelAndView model = new ModelAndView();
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			TbMemberDAO tbmDAO = new TbMemberDAO();
			TbMemberModel tbmModel = tbmDAO.FindByID(id);
			
			request.setAttribute("tbmModel", tbmModel);
			
			return model;
		} catch (Exception e) {
			//model.addObject("exception", e);
			//model.addObject("url", request.getRequestURL());
			//model.setViewName("error");
		}
		return model;
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public JsonResponseModel update(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/html;charset=UTF-8");

		System.out.println("Update Page Requested");
		JsonResponseModel json = new JsonResponseModel();
		try {
			String fname = request.getParameter("fname");
			String lname = request.getParameter("lname");
			String gender = request.getParameter("gender");
			int id = Integer.parseInt(request.getParameter("id"));
			
			System.out.println(id + ", " + fname + ", " + lname + ", " + gender);
			
			TbMemberModel tbmModel = new TbMemberModel(id, fname, fname, gender, "");
			TbMemberDAO tbmDAO = new TbMemberDAO();
			int tbmId = tbmDAO.Update(tbmModel);
			
			System.out.println("Updated ID: " + tbmId);
			
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
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	@ResponseBody
	public JsonResponseModel delete(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/html;charset=UTF-8");

		System.out.println("Get Page Requested");
		JsonResponseModel json = new JsonResponseModel();
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			
			TbMemberModel tbmModel = new TbMemberModel(id);
			TbMemberDAO tbmDAO = new TbMemberDAO();
			int tbmId = tbmDAO.Delete(tbmModel);
			
			System.out.println("Deleted ID: " + tbmId);
			
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
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logout(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/html;charset=UTF-8");

		System.out.println("Logout Page Requested");
		ModelAndView model = new ModelAndView("redirect:/login");
		try {
			if(session.getAttribute("memberLogin") != null) {
				session.removeAttribute("memberLogin");
			}
			
			return model;
		} catch (Exception e) {
			//model.addObject("exception", e);
			//model.addObject("url", request.getRequestURL());
			//model.setViewName("error");
		}
		return model;
	}
}
