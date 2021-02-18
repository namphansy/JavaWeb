package psn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import psn.model.dao.UserDAO;
import psn.model.entity.WebUser;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private UserDAO userRepository;
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		WebUser user = userRepository.findByUserName(userName)
				.orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + userName));
		return UserDetailsImpl.build(user);
	}

}

