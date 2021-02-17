package psn.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import psn.model.dao.UserGroupDAO;
import psn.model.entity.WebUser;

@Service
public class UserGroupServiceImp implements UserGroupService{
	
	@Autowired
	private UserGroupDAO userGroup;
	
	@Override
	public boolean saveNewAdmin(WebUser webUser) {
		// TODO Auto-generated method stub
		return userGroup.saveNewAdmin(webUser);
	}

}
