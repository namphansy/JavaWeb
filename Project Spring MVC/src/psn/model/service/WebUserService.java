package psn.model.service;

import java.util.List;

import psn.model.entity.WebUser;

public interface WebUserService {
	public WebUser getUserByUserName(String userName);
	public List<WebUser> getAllWebUser();
	public List<WebUser> getAllWebAdmin();
	public boolean save(WebUser webUser);
	public boolean merge(WebUser webUser);
	public Integer totalAccountUser();
	public boolean checkUserNameRegister(String userName);
}
