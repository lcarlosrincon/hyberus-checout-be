package com.hiberus.checkout.order.service.impl;

import org.springframework.stereotype.Service;

import com.hiberus.checkout.order.dto.Order;
import com.hiberus.checkout.order.service.BillService;

@Service
public class BillServiceMockImpl implements BillService {

	@Override
	public Double calculateTotal(Order order) {
		return order.getProducts().stream().map(product -> product.getQuantity() * product.getPrice()).reduce(0.0,
				(a, b) -> a + b);
	}

}
