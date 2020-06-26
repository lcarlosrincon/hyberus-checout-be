package com.hiberus.checkout.order.service;

import com.hiberus.checkout.order.dto.Order;

public interface LogisticService {

	String LOGISTIC_RESOURCE = "/logistic";

	String create(Order order);

}
