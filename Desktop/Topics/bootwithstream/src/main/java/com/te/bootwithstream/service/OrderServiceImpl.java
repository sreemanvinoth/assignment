package com.te.bootwithstream.service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.bootwithstream.entity.Customer;
import com.te.bootwithstream.entity.Order;
import com.te.bootwithstream.entity.Product;
import com.te.bootwithstream.repository.CustomerDAO;
import com.te.bootwithstream.repository.OrderDAO;
import com.te.bootwithstream.repository.ProductDAO;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDAO orderDAO;

	@Autowired
	private ProductDAO productDAO;

	@Autowired
	private CustomerDAO customerDAO;

	@Override
	public Order addOrder(Order order, Long id) {

		Optional<Customer> customerId = customerDAO.findById(id);
		if (customerId.isPresent()) {
			order.setCustomer(customerId.get());
		}

		return orderDAO.save(order);
	}

	@Override
	public List<Order> orderList(String category) {
//		String category = request.getCategory();

		List<Order> collect = orderDAO.findAll().stream()
				.filter(o -> o.getProducts().stream().anyMatch(p -> p.getCategory().equalsIgnoreCase(category)))
				.collect(Collectors.toList());
		return collect;
	}

	@Override
	public List<Product> getOrdersByCustomer() {

		List<Product> collect = orderDAO.findAll().stream().filter(o -> o.getCustomer().getTier() == 2)
				.filter(o -> o.getOrderDate().compareTo(LocalDate.of(2021, 2, 1)) >= 0)
				.filter(o -> o.getOrderDate().compareTo(LocalDate.of(2021, 4, 1)) <= 0)
				.flatMap(o -> o.getProducts().stream()).distinct().collect(Collectors.toList());

		return collect;
	}

	@Override
	public List<Order> getRecent() {

		List<Order> collect = orderDAO.findAll().stream()
				.sorted(Comparator.comparing(Order::getOrderDate).reversed())
				.limit(3).collect(Collectors.toList());

		return collect;
	}

	@Override
	public List<Product> getOrderLog() {

		List<Product> collect = orderDAO.findAll().stream()
				.filter(o -> o.getOrderDate().equals(LocalDate.of(2021, 3, 15))).peek(o -> System.out.println(o))
				.flatMap(o -> o.getProducts().stream()).distinct().collect(Collectors.toList());

		return collect;
	}

	@Override
	public Double lumpSum() {
		/*
		 * // LocalDate date = LocalDate.parse("2022-12-12");
		 * 
		 */
		Double sum = orderDAO.findAll().stream().filter(o -> o.getOrderDate().compareTo(LocalDate.of(2021, 2, 1)) >= 0)
				.filter(o -> o.getOrderDate().compareTo(LocalDate.of(2021, 3, 1)) < 0)
				.flatMap(o -> o.getProducts().stream())
				.mapToDouble(p -> p.getPrice()).sum();

		return sum;
	}

	@Override
	public Double dayAverage() {
		// date 15 works but not date 14
		Double asDouble = orderDAO.findAll().stream().filter(o -> o.getOrderDate().isEqual(LocalDate.of(2021, 3, 15)))
				.peek(System.out::println).flatMap(o -> o.getProducts().stream()).mapToDouble(p -> p.getPrice())
				.average().getAsDouble();

		return asDouble;
	}

	@Override
	public Map<Long, Integer> obtainMap() {

		Map<Long, Integer> collect = orderDAO.findAll().stream()
				.collect(Collectors.toMap(order -> order.getId(), order -> order.getProducts().size()));

		return collect;
	}

	@Override
	public Map<Customer, List<Order>> mapCustomer() {

		Map<Customer, List<Order>> collect = orderDAO.findAll().stream()
				.collect(Collectors.groupingBy(Order::getCustomer));

		return collect;
	}

	@Override
	public Map<Order, Double> mapProductSum() {

		Map<Order, Double> collect = orderDAO.findAll().stream().collect(Collectors.toMap(Function.identity(),
				order -> order.getProducts().stream().mapToDouble(product -> product.getPrice()).sum()));

		return collect;
	}

}
