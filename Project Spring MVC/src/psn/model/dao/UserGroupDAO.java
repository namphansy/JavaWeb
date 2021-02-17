package psn.model.dao;

import psn.model.entity.WebUser;

public interface UserGroupDAO {
	public boolean saveNewAdmin(WebUser webUser);
}
