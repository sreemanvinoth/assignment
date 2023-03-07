package com.te.bootwithstream.dto;

import com.te.bootwithstream.entity.Product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequest {

	private Product product;

}
