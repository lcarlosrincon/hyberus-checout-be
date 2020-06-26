package com.hiberus.checkout.order.service;

import com.hiberus.checkout.order.dto.Order;

public interface LogisticService {

	String create(Order order, Double total);

}
