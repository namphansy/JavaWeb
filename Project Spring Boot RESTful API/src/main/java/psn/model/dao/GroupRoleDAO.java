package psn.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import psn.model.entity.WebGroup;

public interface GroupRoleDAO extends JpaRepository<WebGroup, Integer>{

}
