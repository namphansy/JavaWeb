package psn.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import psn.model.entity.ReportItem;
import psn.model.entity.WebUser;
import psn.model.service.ProductService;
import psn.model.service.ReportService;
import psn.model.service.WebUserService;

@Controller
public class HomeController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private WebUserService userService;
	
	@Autowired
	private ReportService reportService;
	
	/*------ Lấy số sản phẩm trong kho -----------*/
	@RequestMapping("/admin")
	private ModelAndView totalProduct() {
		
		ModelAndView mav = new ModelAndView("home");
		int totalProductActive = productService.totalProdcutActive(true);
		mav.addObject("totalProductActive", totalProductActive);
		
		int totalProductInActive = productService.totalProdcutActive(false);
		mav.addObject("totalProductInActive", totalProductInActive);
		
		int totalAccountUser = userService.totalAccountUser();
		mav.addObject("totalAccountUser", totalAccountUser);
		
		List<ReportItem> list = listReportItem();
		mav.addObject("listReportItem", list);
		return mav;
	}
	
	private List<ReportItem> listReportItem(){
		Date date = new Date();
		List<ReportItem> list = reportService.reportReceipt(date, 7);
		return list;
	}
}
