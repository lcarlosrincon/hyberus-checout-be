package com.hiberus.checkout.order.service.impl;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hiberus.checkout.order.service.JsonReader;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class JsonReaderImpl implements JsonReader {

	@Override
	public <T> T read(String source, Class<T> type) {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		try {
			return mapper.readValue(source, type);
		} catch (JsonProcessingException e) {
			log.error("Error en la conversion de datos " + source, e);
			throw new RuntimeException(e);
		}
	}

}
