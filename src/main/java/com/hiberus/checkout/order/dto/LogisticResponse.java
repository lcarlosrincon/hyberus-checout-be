package com.hiberus.checkout.order.dto;

public class LogisticResponse extends ObjectResponseSuccess<Order> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4388086582324546530L;

	public LogisticResponse(Order data) {
		super(data);
	}

	public LogisticResponse() {
		super(null);
	}

}
