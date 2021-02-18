package psn.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import psn.model.entity.Orders;

public interface OrderDAO extends JpaRepository<Orders, Integer>{
	
}
