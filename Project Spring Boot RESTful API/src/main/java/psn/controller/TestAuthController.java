package psn.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/testAuth")
public class TestAuthController {
	
	@RequestMapping("/user")
	@PreAuthorize("hasRole('ROLE_USER')")
	public String userAccess() {
		return "USER_ACCESS";
	}
	
	@RequestMapping("/admin")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String adminAccess() {
		return "ADMIN_ACCESS";
	}
}
