package com.te.bootwithstream.service;

import java.util.List;

import com.te.bootwithstream.entity.Customer;
import com.te.bootwithstream.entity.Product;

public interface CustomerService {

	public Customer addCustomer(Customer customer);

	public List<Product> customerList();

}
