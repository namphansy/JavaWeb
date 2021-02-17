package psn.model.dao;

import java.util.List;

import psn.model.entity.WebUser;

public interface UserDAO {
	public WebUser getUserByUserName(String userName);
	public List<WebUser> getAllWebUser();
	public List<WebUser> getAllWebAdmin();
	public boolean save(WebUser webUser);
	public boolean merge(WebUser webUser);
	public Integer totalAccountUser();
}
