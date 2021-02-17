package psn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import psn.model.entity.OrderDetail;
import psn.model.entity.Orders;
import psn.model.service.OrderDetailService;
import psn.model.service.OrderService;

@Controller
//@RequestMapping("/ordersController")
public class OrdersController {
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private OrderDetailService orderDetailService;
	
	@RequestMapping(value = "/adminGetAllOrders.htm")
	private ModelAndView getAllOrders() {
		ModelAndView mav = new ModelAndView("listAllOrders");
		List<Orders> listOrders = orderService.listOrders();
		mav.addObject("listOrders", listOrders);
		return mav;
	}
	
	@RequestMapping(value = "/adminGetOrderDetailsById")
	private @ResponseBody 
	List<OrderDetail> getOrderDetailsById(int orderId){
		List<OrderDetail> listOrderDetail = orderDetailService.listByOrderId(orderId);
		return listOrderDetail;
	}
	
	@RequestMapping(value = "/updateOrders.htm", method = RequestMethod.GET)
	private String updateStatusOrders(int ordersId) {
		Orders orders = orderService.findById(ordersId);
		boolean check = orderService.updateStatusOrders(orders);
		
		if(check == true) {
			return "redirect:getAllOrders.htm";
		}
		return "error";
	}
}
