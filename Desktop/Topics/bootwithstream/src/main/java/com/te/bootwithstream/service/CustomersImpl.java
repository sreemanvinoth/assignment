package com.te.bootwithstream.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.bootwithstream.entity.Customer;
import com.te.bootwithstream.entity.Product;
import com.te.bootwithstream.repository.CustomerDAO;

@Service
public class CustomersImpl implements CustomerService {
	
	@Autowired
	private CustomerDAO customerDAO;
	
	@Override
	public Customer addCustomer(Customer customer) {
		return customerDAO.save(customer);
	}

	@Override
	public List<Product> customerList() {
		return null;
	}

}
