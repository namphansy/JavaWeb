package psn.model.service;

import java.util.List;

import psn.model.entity.Orders;

public interface OrderService {
	public List<Orders> listOrders();
	public boolean updateStatusOrders(Orders orders);
	public Orders findById(int ordersId);
	
}
