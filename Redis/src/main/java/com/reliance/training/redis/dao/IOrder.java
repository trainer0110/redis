package com.reliance.training.redis.dao;

import java.util.List;

import com.reliance.training.redis.model.Order;

public interface IOrder {

	public Order addOrder(Order order);

	public Order getOrder(String orderId);

	public List<Order> getAllOrder();

	public String removeOrder(String orderId);

}
