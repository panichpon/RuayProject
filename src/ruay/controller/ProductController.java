package ruay.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ruay.dao.TbStockDAO;
import ruay.model.TbStockModel;

@Controller
@RequestMapping("/product")
public class ProductController {
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView home(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/html;charset=UTF-8");

		System.out.println("Home Page Requested");	
		ModelAndView model = new ModelAndView(); // home.jsp
		try {
			if (session.getAttribute("memberLogin") != null) {
				
				TbStockDAO stockDAO = new TbStockDAO();
				ArrayList<TbStockModel> stockList = stockDAO.FindAll();
				
				System.out.println(stockList.size());
				
				request.setAttribute("stockList", stockList);

				return model;
			} else {
				System.out.println("Not Login!");
				return new ModelAndView("redirect:/");
			}

		} catch (Exception e) {
			e.printStackTrace();
			// model.addObject("exception", e);
			// model.addObject("url", request.getRequestURL());
			// model.setViewName("error");
		}
		return model;
	}
}
