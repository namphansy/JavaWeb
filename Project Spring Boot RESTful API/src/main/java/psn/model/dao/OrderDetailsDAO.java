package psn.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import psn.model.entity.OrderDetail;

public interface OrderDetailsDAO extends JpaRepository<OrderDetail, Integer>{

}
