package psn.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/")
public class LoginController {
	@RequestMapping(value = { "/login", "/" })
	public String login(@RequestParam(value = "error", required = false) final String error, final Model model ) {
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		if(principal instanceof UserDetails) return "redirect:admin";
		
		if(error != null) {
			model.addAttribute("message", "Đăng nhập thất bại!");
		}
		return "login";
		
		
	}
	
//	@RequestMapping("/admin")
//	public String admin() {
//	   return "home";
//	}
	 
    @RequestMapping("/logout")
	public String logout(final Model model) {
	  model.addAttribute("message", "Bạn đã đăng xuất");
	  return "login";
	}
}
