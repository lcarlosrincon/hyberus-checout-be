package com.hiberus.checkout.order.dto;

public class BillResponse extends ObjectResponseSuccess<ProductsResponse> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1274875489213257315L;

	public BillResponse(ProductsResponse data) {
		super(data);
	}

	public BillResponse() {
		super(null);
	}

}
