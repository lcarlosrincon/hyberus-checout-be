package com.hiberus.checkout.order.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hiberus.checkout.order.dto.NewOrderDataResponse;
import com.hiberus.checkout.order.dto.Order;
import com.hiberus.checkout.order.service.BillService;
import com.hiberus.checkout.order.service.CheckoutService;
import com.hiberus.checkout.order.service.LogisticService;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class CheckoutServiceImpl extends HiberusCheckoutServiceBaseImpl implements CheckoutService {

	@Autowired
	private BillService billService;

	@Autowired
	private LogisticService logisticService;

	@Override
	public NewOrderDataResponse createOrder(Order order) {
		Double total = this.billService.calculateTotal(order);
		log.debug("The totl cost of the order {} is {}", order.getClientId(), total);
		String id = this.logisticService.create(order);
		log.debug("Order finished", order.getClientId(), total, id);
		return NewOrderDataResponse.builder().order(order).total(total).build();
	}

	public BillService getBillService() {
		return billService;
	}

	public void setBillService(BillService billService) {
		this.billService = billService;
	}

	public LogisticService getLogisticService() {
		return logisticService;
	}

	public void setLogisticService(LogisticService logisticService) {
		this.logisticService = logisticService;
	}

}
