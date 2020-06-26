package com.hiberus.checkout.order.dto;

import lombok.Data;

@Data
public class ProductsResponse {

	private Products order;
	private Double total;

}
