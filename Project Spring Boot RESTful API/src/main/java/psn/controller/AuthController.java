package psn.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import psn.dto.JwtResponse;
import psn.dto.LoginRequest;
import psn.model.dao.GroupRoleDAO;
import psn.model.dao.UserDAO;
import psn.model.dao.UserGroupDAO;
import psn.model.entity.UserGroup;
import psn.model.entity.WebGroup;
import psn.model.entity.WebUser;
import psn.security.JwtUtils;
import psn.service.UserDetailsImpl;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
	private UserDAO userService;
	
	@Autowired
	private UserGroupDAO userGroupService;
	
	@Autowired
	private GroupRoleDAO groupRoleService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtUtils jwtUtils;
	
	@PostMapping("/signIn")
	private ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		List<String> roles = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());
		
		return ResponseEntity.ok(new JwtResponse(jwt,
				userDetails.getId(),
				userDetails.getUsername(),
				roles));
		
	}
	
	@PostMapping("/register")
	private ResponseEntity<?> register(@RequestBody WebUser webUser) {
		
		if(userService.existsByUserName(webUser.getUserName()) == true) {
			return ResponseEntity
					.badRequest()
					.body("Tên đăng ký đã tồn tại");
		}
		
		// đổi pass sang BCrypt
		String pass = webUser.getPass();
		String hash = BCrypt.hashpw(pass, BCrypt.gensalt(10));
		webUser.setPass(hash);
		
		userService.save(webUser);
		
		// Đặt role User cho tài khoản vừa tạo
		WebGroup wg = groupRoleService.findById(2).orElseThrow();
		UserGroup userGroup = new UserGroup();
		userGroup.setWebGroup(wg);
		userGroup.setWebUser(webUser);
		userGroupService.save(userGroup);
		
		return ResponseEntity.ok("Đã đăng ký thành công !!!");
	}
	
//	@PostMapping("/register")
//	private WebUser register(@RequestBody WebUser webUser) {
//		String pass = webUser.getPass();
//		String hash = BCrypt.hashpw(pass, BCrypt.gensalt(10));
//		webUser.setPass(hash);
//		
//		userService.save(webUser);
//		WebGroup group = new WebGroup(2, "ROLE_USER", true);
////		
//		UserGroup userGroup = new UserGroup();
//		userGroup.setWebGroup(group);
//		userGroup.setWebUser(webUser);
//		userGroupService.saveAndFlush(userGroup);
//		
//		return webUser;
//	}
	
}
