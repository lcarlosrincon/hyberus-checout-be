package com.hiberus.checkout.order.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.hiberus.checkout.order.dto.Order;
import com.hiberus.checkout.order.dto.Products;

@Component
public class OrderToProductsConverter implements Converter<Order, Products> {

	@Override
	public Products convert(Order source) {
		Products target = new Products();
		target.setProducts(source.getProducts());
		return target;
	}

}
