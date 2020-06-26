package com.hiberus.checkout.order.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.hiberus.checkout.order.dto.BillResponse;
import com.hiberus.checkout.order.dto.Order;
import com.hiberus.checkout.order.dto.Products;
import com.hiberus.checkout.order.service.BillService;
import com.hiberus.checkout.order.service.JsonReader;

import lombok.extern.slf4j.Slf4j;

@Service
@Primary
@Slf4j
public class BillServiceImpl extends HiberusCheckoutServiceBaseImpl implements BillService {

	private static final String BILL_SERVICE = "/bill";
	private String url;

	private RestTemplate restTemplate;
	private JsonReader jsonReader;

	@Override
	public Double calculateTotal(Order order) {
		String url = this.url + BILL_SERVICE;
		log.debug("Calling bill service");
		Products request = this.getConversionService().convert(order, Products.class);
		ResponseEntity<BillResponse> response = this.restTemplate.exchange(url, HttpMethod.PUT,
				new HttpEntity<>(request), BillResponse.class);
//		BillResponse response = this.restTemplate.patchForObject(url, request, BillResponse.class);
		if (response.getStatusCode() == HttpStatus.OK
				&& response.getBody().getStatusCode().equals(HttpStatus.OK.getReasonPhrase())) {
			return response.getBody().getData().getTotal();
		}
		log.warn("Error presented in bill called service");
		throw new RuntimeException(response.getStatusCode() + "");
	}

	public String getUrl() {
		return url;
	}

	@Autowired
	@Value("${com.hiberus.checkout.bill.endpoint}")
	public void setUrl(String url) {
		this.url = url;
	}

	public RestTemplate getRestTemplate() {
		return restTemplate;
	}

	@Autowired
	public void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public JsonReader getJsonReader() {
		return jsonReader;
	}

	@Autowired
	public void setJsonReader(JsonReader jsonReader) {
		this.jsonReader = jsonReader;
	}
}
