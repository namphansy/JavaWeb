package psn.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import psn.model.dao.UserDAO;
import psn.model.entity.WebUser;

@Service
public class WebUserDetailService implements UserDetailsService {
	@Autowired
	private UserDAO userDAO;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		WebUser webUser = userDAO.getUserByUserName(username);
		if (webUser == null) {
			return null;
		} else {
			boolean enabled = webUser.isUserEnabled();
			boolean accountNonExpired = true;
			boolean credentialsNonExpired = true;
			boolean accountNonLocked = true;
			return new User(username, webUser.getPass(), enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, webUser.getAuthorities());
		}
	}

}
