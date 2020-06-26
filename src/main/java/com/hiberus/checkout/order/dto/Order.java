package com.hiberus.checkout.order.dto;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hiberus.checkout.order.utils.Constants;

import lombok.Data;

@Data
public class Order {
	
	private String id;

	@NotNull
	private Long clientId;

	@JsonFormat(shape = JsonFormat.Shape.OBJECT, pattern = Constants.FORMAT_DATE_TIME)
	@DateTimeFormat(pattern = Constants.FORMAT_DATE_TIME)
	@NotNull(message = "Order dte is required")
	private LocalDateTime date;

	@NotNull
	private String direction;

	@NotEmpty
	@Valid
	private List<Product> products;

}