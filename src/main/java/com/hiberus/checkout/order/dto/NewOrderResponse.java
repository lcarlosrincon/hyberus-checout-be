package com.hiberus.checkout.order.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NewOrderResponse {
	private String statusCode;
	private NewOrderDataResponse newOrderDataResponse;

	@JsonProperty("statusCode")
	public String getStatusCode() {
		return statusCode;
	}

	@JsonProperty("statusCode")
	public void setStatusCode(String value) {
		this.statusCode = value;
	}

	@JsonProperty("data")
	public NewOrderDataResponse getNewOrderDataResponse() {
		return newOrderDataResponse;
	}

	@JsonProperty("data")
	public void setNewOrderDataResponse(NewOrderDataResponse value) {
		this.newOrderDataResponse = value;
	}
}
