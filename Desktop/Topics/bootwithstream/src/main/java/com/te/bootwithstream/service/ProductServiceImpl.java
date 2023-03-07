package com.te.bootwithstream.service;

import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.bootwithstream.entity.Order;
import com.te.bootwithstream.entity.Product;
import com.te.bootwithstream.repository.OrderDAO;
import com.te.bootwithstream.repository.ProductDAO;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDAO productDAO;

	@Autowired
	private OrderDAO orderDAO;

	@Override
	public Product addProduct(Product product) {

		List<Order> list = orderDAO.findAll();
		Set<Order> orders = new HashSet<>(list);
		product.setOrders(orders);

		return productDAO.save(product);
	}

	@Override
	public List<Product> productListwithDiscount(String category, Double percentage) {
		List<Product> result = productDAO.findAll().stream().filter(p -> p.getCategory().equalsIgnoreCase(category))
				.map(p -> p.withPrice(p.getPrice() * 1 - (percentage / 100))).collect(Collectors.toList());
		Double double1 = 1 - (percentage / 100);
		System.out.println(double1);
		return result;
	}

	@Override
	public List<Product> categoryWithPrice(String category, Double price) {

//		List<Product> findAll = productDAO.findAll();
//		String category = pPriceDto.getCategory();
//		Double price = pPriceDto.getPrice();

		List<Product> collect = productDAO.findAll().stream().filter(p -> p.getCategory().equalsIgnoreCase(category))
				.filter(p -> p.getPrice() > price).collect(Collectors.toList());
		return collect;
	}

	@Override
	public Optional<Product> getProductsLowest(String category) {

		Optional<Product> findFirst = productDAO.findAll().stream()
				.filter(p -> p.getCategory().equalsIgnoreCase(category)).min(Comparator.comparing(Product::getPrice));
//						.sorted(Comparator.comparing(Product::getPrice)).findFirst();

		return findFirst;
	}

	@Override
	public DoubleSummaryStatistics obtainStatistics(String category) {

		DoubleSummaryStatistics summaryStatistics = productDAO.findAll().stream()
				.filter(p -> p.getCategory().equalsIgnoreCase(category)).mapToDouble(p -> p.getPrice())
				.summaryStatistics();

		return summaryStatistics;
	}

	@Override
	public Map<String, List<String>> listCategory() {

		Map<String, List<String>> collect = productDAO.findAll().stream()
				.collect(Collectors.groupingBy(
				Product::getCategory, Collectors.mapping(product -> product.getName()
						, Collectors.toList())));

		return collect;
	}

	@Override
	public Map<String, Optional<Product>> mostExpensive() {

		Map<String, Optional<Product>> collect = productDAO.findAll().stream().collect(
				Collectors.groupingBy(Product::getCategory, Collectors.maxBy(Comparator.comparing(Product::getPrice))));

		return collect;
	}
}
