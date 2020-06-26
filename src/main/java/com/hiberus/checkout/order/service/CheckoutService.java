package com.hiberus.checkout.order.service;

import com.hiberus.checkout.order.dto.Order;

public interface CheckoutService {

	String createOrder(Order products);

}
