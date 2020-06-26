package com.hiberus.checkout.order.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hiberus.checkout.order.dto.NewOrderDataResponse;
import com.hiberus.checkout.order.dto.ObjectResponseSuccess;
import com.hiberus.checkout.order.dto.Order;
import com.hiberus.checkout.order.service.CheckoutService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.log4j.Log4j2;

@RequestMapping(path = "/checkout")
@RestController
@Log4j2
public class CheckoutController {

	private CheckoutService checkoutService;

	@Operation(summary = "Register a new order in hiberus checkout")
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ObjectResponseSuccess<NewOrderDataResponse>> insert(@RequestBody @Valid Order request) {
		log.debug("Received new order of client:" + request.getClientId());
		NewOrderDataResponse res = this.checkoutService.createOrder(request);
		log.debug("New order was created:" + res);
		return ResponseEntity.status(HttpStatus.OK).body(new ObjectResponseSuccess<NewOrderDataResponse>(res));
	}

	public CheckoutService getCheckoutService() {
		return checkoutService;
	}

	@Autowired
	public void setCheckoutService(CheckoutService checkoutService) {
		this.checkoutService = checkoutService;
	}
}
