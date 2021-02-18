package psn.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.stereotype.Repository;

import psn.model.entity.Material;
@EnableWebSecurity
@Repository
public interface MaterialDAO extends JpaRepository<Material, Integer>{
	
}
