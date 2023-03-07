package com.te.bootwithstream.dto;

import java.util.Set;

import com.te.bootwithstream.entity.Order;
import com.te.bootwithstream.entity.Product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequest {
	
	private Order order;
	
	private Set<Product> product;

}
