package com.hiberus.checkout.order.service;

import com.hiberus.checkout.order.dto.NewOrderDataResponse;
import com.hiberus.checkout.order.dto.Order;

public interface CheckoutService {

	NewOrderDataResponse createOrder(Order products);

}
