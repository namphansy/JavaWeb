package psn.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import psn.model.dao.UserDAO;
import psn.model.entity.WebUser;

@Service
public class WebUserServiceImp implements WebUserService{

	@Autowired
	private UserDAO userDao;
	
	@Override
	public WebUser getUserByUserName(String userName) {
		// TODO Auto-generated method stub
		return userDao.getUserByUserName(userName);
	}

	@Override
	public List<WebUser> getAllWebUser() {
		// TODO Auto-generated method stub
		return userDao.getAllWebUser();
	}

	@Override
	public boolean save(WebUser webUser) {
		// TODO Auto-generated method stub
		return userDao.save(webUser);
	}

	@Override
	public boolean merge(WebUser webUser) {
		// TODO Auto-generated method stub
		return userDao.merge(webUser);
	}

	@Override
	public List<WebUser> getAllWebAdmin() {
		// TODO Auto-generated method stub
		return userDao.getAllWebAdmin();
	}

	@Override
	public Integer totalAccountUser() {
		// TODO Auto-generated method stub
		return userDao.totalAccountUser();
	}

	@Override
	public boolean checkUserNameRegister(String userName) {
		// TODO Auto-generated method stub
		return userDao.checkUserNameRegister(userName);
	}

}
