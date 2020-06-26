package com.hiberus.checkout.order.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;

@Builder
public class NewOrderDataResponse {

	private String id;

	@JsonProperty("id")
	public String getId() {
		return this.id;
	}

	@JsonProperty("id")
	public void setId(String value) {
		this.id = value;
	}

}
