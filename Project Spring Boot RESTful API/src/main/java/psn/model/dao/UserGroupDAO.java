package psn.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import psn.model.entity.UserGroup;

public interface UserGroupDAO extends JpaRepository<UserGroup, Integer> {

}
