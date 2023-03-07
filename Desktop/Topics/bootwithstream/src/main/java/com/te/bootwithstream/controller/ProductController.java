package com.te.bootwithstream.controller;

import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.te.bootwithstream.entity.Customer;
import com.te.bootwithstream.entity.Order;
import com.te.bootwithstream.entity.Product;
import com.te.bootwithstream.response.SuccessResponse;
import com.te.bootwithstream.service.CustomerService;
import com.te.bootwithstream.service.OrderService;
import com.te.bootwithstream.service.ProductService;

@RestController
//@RequestMapping(value = "/product", produces = "application/json", consumes = "application/json")
public class ProductController {

	@Autowired
	private ProductService productService;

	@Autowired
	private OrderService orderService;

	@Autowired
	private CustomerService customerService;

	@PostMapping("/saveProduct")
	public ResponseEntity<SuccessResponse> saveProduct(@RequestBody Product product) {
		Product addProduct = productService.addProduct(product);
		if (addProduct != null) {
			return new ResponseEntity<SuccessResponse>(
					SuccessResponse.builder().data(addProduct).error(false).msg("success").build(), HttpStatus.OK);
		} else {
			return new ResponseEntity<SuccessResponse>(
					SuccessResponse.builder().data(addProduct).error(true).msg("Failure").build(),
					HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/getDiscountQ3/{category}/{percentage}")
	public ResponseEntity<SuccessResponse> getDiscount(@PathVariable(required = true) String category,
			@PathVariable(required = true) Integer percentage) {
		List<Product> discountList = productService.productListwithDiscount(category, percentage + 0.0);
		if (!discountList.isEmpty()) {
			return new ResponseEntity<SuccessResponse>(
					SuccessResponse.builder().data(discountList).error(false).msg("success").build(), HttpStatus.OK);
		} else {
			return new ResponseEntity<SuccessResponse>(
					SuccessResponse.builder().data(discountList).error(true).msg("Failure").build(),
					HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/saveOrder")
	public ResponseEntity<SuccessResponse> saveOrder(@RequestBody Order order, @PathVariable Long id) {

		Order addOrder = orderService.addOrder(order, id);
		if (addOrder != null) {
			return new ResponseEntity<SuccessResponse>(
					SuccessResponse.builder().data(addOrder).error(false).msg("success").build(), HttpStatus.OK);
		} else {
			return new ResponseEntity<SuccessResponse>(
					SuccessResponse.builder().data(addOrder).error(true).msg("Failure").build(),
					HttpStatus.BAD_REQUEST);
		}

	}

	@PostMapping("/saveCustomer")
	public ResponseEntity<SuccessResponse> saveCustomer(@RequestBody Customer customer) {

		Customer addCustomer = customerService.addCustomer(customer);
		if (addCustomer != null) {
			return new ResponseEntity<SuccessResponse>(
					SuccessResponse.builder().data(addCustomer).error(false).msg("success").build(), HttpStatus.OK);
		} else {
			return new ResponseEntity<SuccessResponse>(
					SuccessResponse.builder().data(addCustomer).error(true).msg("Failure").build(),
					HttpStatus.BAD_REQUEST);
		}

	}

//	@RequestMapping(method = RequestMethod.GET, value = "/getProductsWithPrice/{category}/{price}")
//	@PostMapping("/getProductsWithPrice")
	@GetMapping(value = "/getOrderListQ1/{category}/{price}")
	public ResponseEntity<SuccessResponse> getProductsBasedOnPrice(
			@PathVariable(value = "category", required = true) String category,
			@PathVariable(value = "price", required = true) Double price) {

		List<Product> categoryWithPrice = productService.categoryWithPrice(category, price);

		if (!categoryWithPrice.isEmpty()) {
			return new ResponseEntity<SuccessResponse>(
					SuccessResponse.builder().data(categoryWithPrice).error(false).msg("success").build(),
					HttpStatus.OK);
		} else {
			return new ResponseEntity<SuccessResponse>(
					SuccessResponse.builder().data(categoryWithPrice).error(true).msg("Failure").build(),
					HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping(value = "/getOrderListQ2/{category}")
	public ResponseEntity<SuccessResponse> getOrder(
			@PathVariable(value = "category", required = true) String category) {

		List<Order> orderList = orderService.orderList(category);

		if (!orderList.isEmpty()) {
			return new ResponseEntity<SuccessResponse>(
					SuccessResponse.builder().data(orderList).error(false).msg("success").build(), HttpStatus.OK);
		} else {
			return new ResponseEntity<SuccessResponse>(
					SuccessResponse.builder().data(orderList).error(true).msg("Failure").build(),
					HttpStatus.BAD_REQUEST);
		}

	}

	@GetMapping("/getProductsByCustomerQ4")
	public ResponseEntity<SuccessResponse> getProductListByCustomer() {
		List<Product> ordersByCustomer = orderService.getOrdersByCustomer();

		if (!ordersByCustomer.isEmpty()) {
			return new ResponseEntity<SuccessResponse>(
					SuccessResponse.builder().data(ordersByCustomer).error(false).msg("Success").build(),
					HttpStatus.OK);

		} else {
			return new ResponseEntity<SuccessResponse>(
					SuccessResponse.builder().data(ordersByCustomer).error(true).msg("Failure").build(),
					HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(method = RequestMethod.GET, value = "/getLowestProductQ5/{category}")
	public ResponseEntity<SuccessResponse> getLowestProduct(@PathVariable(value = "category") String category) {
		Optional<Product> productsLowest = productService.getProductsLowest(category);

		if (productsLowest.isPresent()) {
			return new ResponseEntity<SuccessResponse>(
					SuccessResponse.builder().data(productsLowest).error(false).msg("Success").build(), HttpStatus.OK);
		} else {
			return new ResponseEntity<SuccessResponse>(
					SuccessResponse.builder().data(productsLowest).error(true).msg("Failure").build(),
					HttpStatus.NOT_ACCEPTABLE);
		}
	}

	@GetMapping("/getRecentOrdersQ6")
	public ResponseEntity<SuccessResponse> getRecentOrders() {
		List<Order> recent = orderService.getRecent();

		if (!recent.isEmpty()) {
			return new ResponseEntity<SuccessResponse>(
					SuccessResponse.builder().data(recent).error(false).msg("Success").build(), HttpStatus.OK);
		} else {
			return new ResponseEntity<SuccessResponse>(
					SuccessResponse.builder().data(recent).error(true).msg("Failure").build(), HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/getOrderLogsQ7")
	public ResponseEntity<SuccessResponse> getOrderLogs() {

		List<Product> orderLog = orderService.getOrderLog();

		if (!orderLog.isEmpty()) {
			return new ResponseEntity<SuccessResponse>(
					SuccessResponse.builder().data(orderLog).error(false).msg("Success").build(), HttpStatus.OK);
		} else {
			return new ResponseEntity<SuccessResponse>(
					SuccessResponse.builder().data(orderLog).error(true).msg("Failure").build(),
					HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/getTotalSummaryQ8")
	public ResponseEntity<SuccessResponse> getTotalSummary() {
		Double lumpSum = orderService.lumpSum();

		if (lumpSum != 0) {
			return new ResponseEntity<SuccessResponse>(
					SuccessResponse.builder().data(lumpSum).error(false).msg("Success").build(), HttpStatus.OK);
		} else {
			return new ResponseEntity<SuccessResponse>(
					SuccessResponse.builder().data(lumpSum).error(true).msg("Failure").build(), HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/getAverageQ9")
	public ResponseEntity<SuccessResponse> getAverage() {
		Double dayAverage = orderService.dayAverage();

		if (dayAverage != 0) {
			return new ResponseEntity<SuccessResponse>(
					SuccessResponse.builder().data(dayAverage).error(false).msg("Success").build(), HttpStatus.OK);
		} else {
			return new ResponseEntity<SuccessResponse>(
					SuccessResponse.builder().data(dayAverage).error(true).msg("Failure").build(),
					HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/getStatisticQ10/{category}")
	public ResponseEntity<SuccessResponse> getStatistic(@PathVariable(value = "category") String category) {

		DoubleSummaryStatistics obtainStatistics = productService.obtainStatistics(category);

		if (obtainStatistics != null) {
			return new ResponseEntity<SuccessResponse>(SuccessResponse.builder()
					.data(String.format("count = " + obtainStatistics.getCount() + ", average = "
							+ obtainStatistics.getAverage() + ", max = " + obtainStatistics.getMax() + ", min = "
							+ obtainStatistics.getMin() + ", sum = " + obtainStatistics.getSum()))
					.msg("Success").build(), HttpStatus.OK);
		} else {
			return new ResponseEntity<SuccessResponse>(
					SuccessResponse.builder().data(obtainStatistics).error(true).msg("Failure").build(),
					HttpStatus.NO_CONTENT);
		}
	}

	@GetMapping("/ordersInMapQ11")
	public ResponseEntity<SuccessResponse> ordersInMap() {

		Map<Long, Integer> obtainMap = orderService.obtainMap();

		if (!obtainMap.isEmpty()) {
			return new ResponseEntity<SuccessResponse>(
					SuccessResponse.builder().data(obtainMap).msg("Success").error(false).build(), HttpStatus.OK);
		} else {
			return new ResponseEntity<SuccessResponse>(
					SuccessResponse.builder().data(obtainMap).error(true).msg("failure").build(),
					HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/mapCustomerQ12")
	public ResponseEntity<SuccessResponse> mapCustomer() {
		Map<Customer, List<Order>> mapCustomer = orderService.mapCustomer();

		if (!mapCustomer.isEmpty()) {
			return new ResponseEntity<SuccessResponse>(
					SuccessResponse.builder().data(mapCustomer).msg("Success").error(false).build(), HttpStatus.OK);
		} else {
			return new ResponseEntity<SuccessResponse>(SuccessResponse.builder().data(mapCustomer).error(true).build(),
					HttpStatus.BAD_GATEWAY);
		}
	}

	@GetMapping("/mapProductSumQ13")
	public ResponseEntity<SuccessResponse> mapProductSum() {
		Map<Order, Double> mapProductSum = orderService.mapProductSum();

		if (!mapProductSum.isEmpty()) {
			return new ResponseEntity<SuccessResponse>(
					SuccessResponse.builder().data(mapProductSum).error(false).msg("Success").build(), HttpStatus.OK);
		} else {
			return new ResponseEntity<SuccessResponse>(
					SuccessResponse.builder().data(mapProductSum).error(true).msg("Failure").build(),
					HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/listProductCategoryQ14")
	public ResponseEntity<SuccessResponse> listCategory() {
		Map<String, List<String>> listCategory = productService.listCategory();

		if (!listCategory.isEmpty()) {
			return new ResponseEntity<SuccessResponse>(
					SuccessResponse.builder().data(listCategory).error(false).msg("Success").build(), HttpStatus.OK);
		} else {
			return new ResponseEntity<SuccessResponse>(
					SuccessResponse.builder().data(listCategory).error(true).msg("Failure").build(),
					HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/maxProductQ15")
	public ResponseEntity<SuccessResponse> maxProduct() {
		Map<String, Optional<Product>> mostExpensive = productService.mostExpensive();
		if (!mostExpensive.isEmpty()) {
			return new ResponseEntity<SuccessResponse>(
					SuccessResponse.builder().data(mostExpensive).error(false).msg("Success").build(), HttpStatus.OK);
		} else {
			return new ResponseEntity<SuccessResponse>(
					SuccessResponse.builder().data(mostExpensive).error(true).msg("Failure").build(),
					HttpStatus.BAD_REQUEST);
		}
	}

}
