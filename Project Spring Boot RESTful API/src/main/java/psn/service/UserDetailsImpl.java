package psn.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import psn.model.entity.UserGroup;
import psn.model.entity.WebUser;

public class UserDetailsImpl implements UserDetails {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int userId;
	private String username;
	private String password;
	private boolean userEnabled;
	private Collection<? extends GrantedAuthority> authorities;
	
	public static UserDetailsImpl build(WebUser webUser) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for (UserGroup userGroup : webUser.getListUserGroup()) {
			authorities.add(new SimpleGrantedAuthority(userGroup.getWebGroup().getGroupName()));
		}
		return new UserDetailsImpl(webUser.getUserId(), 
				webUser.getUserName(), 
				webUser.getPass(), 
				webUser.isUserEnabled(), authorities);
	}
	
	public UserDetailsImpl(int userId, String username, String password, boolean userEnabled,
			Collection<? extends GrantedAuthority> authorities) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.userEnabled = userEnabled;
		this.authorities = authorities;
	}
	
	public Integer getId() {
		return userId;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return userEnabled;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj) return true;
		if(obj == null || getClass() != obj.getClass()) return false;
		UserDetailsImpl user = (UserDetailsImpl) obj;
		return Objects.equals(userId, user.userId);
	}

}
