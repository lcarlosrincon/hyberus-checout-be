package com.hiberus.checkout.order.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.ConversionService;

public class HiberusCheckoutServiceBaseImpl {

	private ConversionService conversionService;

	public ConversionService getConversionService() {
		return conversionService;
	}

	@Autowired
	@Qualifier("mvcConversionService")
	public void setConversionService(ConversionService conversionService) {
		this.conversionService = conversionService;
	}

}
