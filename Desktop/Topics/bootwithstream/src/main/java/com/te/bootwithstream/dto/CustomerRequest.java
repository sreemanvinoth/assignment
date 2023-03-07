package com.te.bootwithstream.dto;

import java.util.Set;

import com.te.bootwithstream.entity.Customer;
import com.te.bootwithstream.entity.Order;

import jakarta.validation.constraints.AssertFalse.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRequest {

	private Customer customer;
	
	private Set<Order> orders;
}
