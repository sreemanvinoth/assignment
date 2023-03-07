package com.te.bootwithstream.service;

import java.util.List;
import java.util.Map;

import com.te.bootwithstream.entity.Customer;
import com.te.bootwithstream.entity.Order;
import com.te.bootwithstream.entity.Product;

public interface OrderService {

	public Order addOrder(Order order,Long id);

	public List<Order> orderList(String category);

	public List<Product> getOrdersByCustomer();
	
	public List<Order> getRecent();
	
	public List<Product> getOrderLog();
	
	public Double lumpSum();
	
	public Double dayAverage();
	
	public Map<Long, Integer> obtainMap();
	
	public Map<Customer, List<Order>> mapCustomer();
	
	public Map<Order, Double> mapProductSum();

}
