package psn.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import psn.model.dao.OrderDetailDAO;
import psn.model.entity.OrderDetail;

@Service
public class OrderDetailServiceImp implements OrderDetailService {
	
	@Autowired
	private OrderDetailDAO orderDetailDao;
	
	@Override
	public List<OrderDetail> listOrderDetail() {
		// TODO Auto-generated method stub
		return orderDetailDao.listOrderDetail();
	}

	@Override
	public List<OrderDetail> listByOrderId(int orderId) {
		// TODO Auto-generated method stub
		return orderDetailDao.listByOrderId(orderId);
	}
	
}
