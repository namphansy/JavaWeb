package psn.dto;

import java.util.List;

public class JwtResponse {
	private String token;
	private String type = "Bearer";
	private int userId;
	private String username;
	private List<String> roles;
	
	public JwtResponse() {
		// TODO Auto-generated constructor stub
	}

	public JwtResponse(String token, int userId, String username, List<String> roles) {
		super();
		this.token = token;
//		this.type = type;
		this.userId = userId;
		this.username = username;
		this.roles = roles;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
	
	
}
