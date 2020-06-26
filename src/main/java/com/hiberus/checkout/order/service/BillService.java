package com.hiberus.checkout.order.service;

import com.hiberus.checkout.order.dto.Order;

public interface BillService {

	Double calculateTotal(Order order);

}
