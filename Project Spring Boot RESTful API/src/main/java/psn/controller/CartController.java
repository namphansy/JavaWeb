package psn.controller;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import psn.model.dao.OrderDAO;
import psn.model.dao.OrderDetailsDAO;
import psn.model.dao.UserDAO;
import psn.model.entity.Orders;
import psn.model.entity.WebUser;

@RestController
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	private OrderDAO orderDAO;
	
	@Autowired
	private OrderDetailsDAO orderDetailsDAO;
	
	@Autowired
	private UserDAO userDAO;
	
	@PostMapping("/payment")
	private ResponseEntity<?> createOrderDAO(@RequestBody Orders orders){
		
		// ngày thực hiện order
		long millis = System.currentTimeMillis(); 
		Date date = new Date(millis);
		orders.setCreated(date);
		
		// lấy thông tin người dùng
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = ((UserDetails)principal).getUsername();
		WebUser user = userDAO.findByUserName(username)
				.orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));
		orders.setWebUserOrders(user);
		
		// Lưu Order
		orderDAO.save(orders);
		return ResponseEntity.ok("Success !!!"); 
	}
}
