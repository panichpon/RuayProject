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

import ruay.dao.TbGoodDAO;
import ruay.model.JsonResponseModel;
import ruay.model.TbGoodModel;
import ruay.model.cart.CartModel;

@Controller
@RequestMapping("/cart")
public class CartController {
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView home(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/html;charset=UTF-8");

		System.out.println("Cart Page Requested");
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
	
	@RequestMapping(value = "/add_cart", method = RequestMethod.POST)
	@ResponseBody
	public JsonResponseModel add_cart(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/html;charset=UTF-8");

		System.out.println("Add Cart Page Requested");
		JsonResponseModel json = new JsonResponseModel();
		try {
			if (session.getAttribute("memberLogin") != null) {
				ArrayList<CartModel> cartList = new ArrayList<CartModel>();
				
				String goodId[] = request.getParameterValues("goodId");
				String stockId[] = request.getParameterValues("stockId");
				String qty[] = request.getParameterValues("qty");
				
				
				System.out.println(goodId.length + " - " + qty.length);
				
				for (int i = 0; i < goodId.length; i++) {
					int gId = Integer.parseInt(goodId[i]);
					int stId = Integer.parseInt(stockId[i]);
					int quantity = Integer.parseInt(qty[i]);
					
					if(quantity > 0) {
						System.out.println(goodId + " - " + quantity + " - " + stId);
						
						TbGoodDAO goodDAO = new TbGoodDAO();
						TbGoodModel goodModel = goodDAO.FindByID(gId);
						
						CartModel cart = new CartModel(goodModel, quantity);
						cartList.add(cart);
					}
				}
				
				session.setAttribute("cartList", cartList); //first set initial session
				
				json.setStatus("1");
				json.setResult("success");
			
			} else {
				;
			}
			
			return json;
		} catch (Exception e) {
			e.printStackTrace();
			//model.addObject("exception", e);
			//model.addObject("url", request.getRequestURL());
			//model.setViewName("error");
		}
		return json;
	}
}
