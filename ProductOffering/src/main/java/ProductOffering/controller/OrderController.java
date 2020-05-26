package ProductOffering.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import ProductOffering.entities.OrderDetails;
import ProductOffering.service.OrderService;

@RestController
public class OrderController {
	
	@Autowired
	private OrderService service;
	
	@GetMapping("/history/{id}")
	public List<OrderDetails> getOrderHistoryList(@PathVariable("id") Long userId) {
		return service.getOrderHistory(userId);
	}

}
