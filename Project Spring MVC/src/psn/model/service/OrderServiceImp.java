package psn.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import psn.model.dao.OrderDAO;
import psn.model.entity.Orders;

@Service
public class OrderServiceImp implements OrderService {
	
	@Autowired
	private OrderDAO orderDao;
	
	@Override
	public List<Orders> listOrders() {
		// TODO Auto-generated method stub
		return orderDao.listOrders();
	}

	@Override
	public boolean updateStatusOrders(Orders orders) {
		// TODO Auto-generated method stub
		return orderDao.updateStatusOrders(orders);
	}

	@Override
	public Orders findById(int ordersId) {
		// TODO Auto-generated method stub
		return orderDao.findById(ordersId);
	}

}
