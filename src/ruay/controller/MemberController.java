package ruay.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/member")
public class MemberController {

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView home(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/html;charset=UTF-8");

		System.out.println("Home Page Requested");
		ModelAndView model = new ModelAndView(); // home.jsp
		try {
			if (session.getAttribute("memberLogin") != null) {
				
				
				return model;
			} else {
				System.out.println("Not Login!");
				return new ModelAndView("redirect:/");
			}

		} catch (Exception e) {
			// model.addObject("exception", e);
			// model.addObject("url", request.getRequestURL());
			// model.setViewName("error");
		}
		return model;
	}
}
