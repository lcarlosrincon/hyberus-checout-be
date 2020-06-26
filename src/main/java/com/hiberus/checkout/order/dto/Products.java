package com.hiberus.checkout.order.dto;

import java.util.List;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class Products {

	@NotEmpty
	private List<Product> products;

}