package psn.model.dao;

import java.util.List;

import psn.model.entity.Orders;

public interface OrderDAO {
	public List<Orders> listOrders();
	public boolean updateStatusOrders(Orders orders);
	public Orders findById(int ordersId);
}
