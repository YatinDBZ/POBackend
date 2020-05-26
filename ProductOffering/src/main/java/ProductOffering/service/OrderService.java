package ProductOffering.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ProductOffering.dao.OrderDAO;
import ProductOffering.entities.OrderDetails;

@Service
public class OrderService {

	@Autowired
	private OrderDAO orderDao;
	
	public List<OrderDetails> getOrderHistory(Long userId) {
		return orderDao.getOrderHistory(userId);
	}
}
