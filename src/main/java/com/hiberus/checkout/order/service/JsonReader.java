package com.hiberus.checkout.order.service;

public interface JsonReader {

	public <T> T read(String json, Class<T> type);

}
