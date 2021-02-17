package psn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import psn.model.entity.WebUser;
import psn.model.service.UserGroupService;
import psn.model.service.WebUserService;

@Controller
public class UserController {
	
	@Autowired
	private WebUserService webUserService;
	
	@Autowired
	private UserGroupService userGroupService;
	
	// Lấy toàn bộ User
	@RequestMapping(value = "/adminGetAllUser.htm")
	private ModelAndView getAllUser() {
		ModelAndView mav = new ModelAndView("listAllUser");
		List<WebUser> listAllUser = webUserService.getAllWebUser();
		mav.addObject("listAllUser", listAllUser);
		return mav;
	}
	
	// Lấy toàn bộ tài khoản Admin
	@RequestMapping(value = "/adminGetAllAdmin.htm")
	private ModelAndView getAllAdmin() {
		ModelAndView mav = new ModelAndView("listAllAdmin");
		List<WebUser> listAllAdmin = webUserService.getAllWebAdmin();
		mav.addObject("listAllAdmin", listAllAdmin);
		return mav;
	}
	
	// Thêm tài khoản Admin
	@RequestMapping(value = "/adminInitInsertUser.htm")
	private ModelAndView initInsertUser() {
		ModelAndView mav = new ModelAndView("saveNewUser");
		WebUser newWebUser = new WebUser();
		mav.addObject("newUser", newWebUser);
		return mav;
	}
	
	@RequestMapping(value = "/insertUser.htm", method = RequestMethod.POST)
	private String insertUser(WebUser newUser) {
		boolean check = webUserService.save(newUser);
		if(check == true) {
			boolean check2 = userGroupService.saveNewAdmin(newUser);
			if (check2 == true) {
				return "redirect:adminGetAllUser.htm";
			}else return "error";
			
		} else return "error";
	}
	
	// Cập nhật tài khoản
	@RequestMapping(value = "/adminInitUpdateUser.htm")
	private ModelAndView initUpdateUser(String userName) {
		ModelAndView mav = new ModelAndView("updateUser");
		WebUser updateUser = new WebUser();
		updateUser = webUserService.getUserByUserName(userName);
		mav.addObject("updateUser", updateUser);
		return mav;
	}
	@RequestMapping(value = "/updateUser.htm", method = RequestMethod.POST)
	private String updateUser(WebUser webUser) {
		boolean check = webUserService.merge(webUser);
		if(check == true) {
			return "redirect:adminGetAllUser.htm";
		} else return "error";
	}
}
