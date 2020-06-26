package com.hiberus.checkout.order.dto;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

import lombok.Data;

@Data
public class Product {

	@NotNull
	private Long id;

	@NotNull
	@Range(max = 100, min = 1)
	private Long quantity;

	@NotNull
	@DecimalMin(inclusive = false, value = "0")
	private Double price;

}
