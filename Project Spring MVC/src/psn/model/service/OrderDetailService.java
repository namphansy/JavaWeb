package psn.model.service;

import java.util.List;
import psn.model.entity.OrderDetail;

public interface OrderDetailService {
	public List<OrderDetail> listOrderDetail();
	public List<OrderDetail> listByOrderId(int orderId);
}
