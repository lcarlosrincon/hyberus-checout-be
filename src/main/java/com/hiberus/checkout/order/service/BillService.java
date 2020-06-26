package com.hiberus.checkout.order.service;

import com.hiberus.checkout.order.dto.Order;

public interface BillService {

	String BILL_RESOURCE = "/bill";

	Double calculateTotal(Order order);

}
