package com.hiberus.checkout.order.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class NewOrderDataResponse {

	private Order order;
	private Double total;

}
