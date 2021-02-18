package psn.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.stereotype.Repository;

import psn.model.entity.Brand;
@EnableWebSecurity
@Repository
public interface BrandDAO extends JpaRepository<Brand, Integer>{

}
