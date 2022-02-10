package com.reliance.training.redis.dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.stereotype.Component;

import com.reliance.training.redis.model.Order;
@Component
public class OrderDaoImpl implements IOrder {

	private final String KEY = "ORDER";

	@Resource(name = "template")
	private HashOperations<String, String, Order> opr;

	@Override
	public Order addOrder(Order order) {
		opr.putIfAbsent(KEY, order.getOrderId(), order);

		return order;
	}

	@Override
	public Order getOrder(String orderId) {
		System.out.println("Calling database....");
		return opr.get(KEY, orderId);
	}

	@Override
	public List<Order> getAllOrder() {
		return opr.values(KEY);
	}

	@Override
	public String removeOrder(String orderId) {
		opr.delete(KEY, orderId);
		return "order deleted";
	}

}
