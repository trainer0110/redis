package com.reliance.training.redis.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.reliance.training.redis.dao.OrderDaoImpl;
import com.reliance.training.redis.model.Order;

@RestController
@EnableCaching
public class OrderController {

	@Autowired
	private OrderDaoImpl order;

	@PostMapping("/order")
	public Order addOrder(@RequestBody Order order) {
		return this.order.addOrder(order);
	}

	@GetMapping("/order/{orderId}")
	@Cacheable(key = "#orderId", value = "ORDER")
	public Order getOrder(@PathVariable String orderId) {
		return this.order.getOrder(orderId);
	}

	@GetMapping("/order")
	public List<Order> getAllOrder() {
		return this.order.getAllOrder();
	}

	@DeleteMapping("/order/{orderId}")
	public String removeOrder(@PathVariable String orderId) {
		return this.order.removeOrder(orderId);
	}

}
