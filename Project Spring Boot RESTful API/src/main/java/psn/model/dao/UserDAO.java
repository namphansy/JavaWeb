package psn.model.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import psn.model.entity.WebUser;

@Repository
public interface UserDAO extends JpaRepository<WebUser, Integer> {
	
	Optional<WebUser> findByUserName(String username);
	
	default boolean existsByUserName(String userName) {
		boolean check = false;
		
		List<WebUser> listUser = findAll();
		for (WebUser user : listUser) {
			if(user.getUserName().equals(userName)) {
				check = true;
				break;
			}
		}
		
		return check;
	}
	
}
