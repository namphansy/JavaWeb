package psn.model.dao;

import java.util.List;

import psn.model.entity.OrderDetail;

public interface OrderDetailDAO {
	public List<OrderDetail> listOrderDetail();
	public List<OrderDetail> listByOrderId(int orderId);
}
