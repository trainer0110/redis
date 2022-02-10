package com.reliance.training.redis.model;

import java.io.Serializable;

public class Order implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 111L;
	
	private String orderId;
	private String orderStatus;
	private String item;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public Order(String orderId, String orderStatus, String item) {
		super();
		this.orderId = orderId;
		this.orderStatus = orderStatus;
		this.item = item;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderStatus=" + orderStatus + ", item=" + item + "]";
	}

}
