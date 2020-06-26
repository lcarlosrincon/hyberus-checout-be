package com.hiberus.checkout.order.service.impl;

import java.util.Random;

import org.springframework.stereotype.Service;

import com.hiberus.checkout.order.dto.Order;
import com.hiberus.checkout.order.service.LogisticService;

@Service
public class LogisticServiceMockImpl implements LogisticService {

	private static final int ORDER_ID_LENGTH = 10;

	@Override
	public String create(Order order, Double total) {
		byte[] randoms = new byte[ORDER_ID_LENGTH];
		new Random().nextBytes(randoms);
		return new String(randoms);
	}

}
