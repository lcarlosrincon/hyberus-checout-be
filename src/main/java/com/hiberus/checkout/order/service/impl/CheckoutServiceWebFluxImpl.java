package com.hiberus.checkout.order.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.hiberus.checkout.order.dto.BillResponse;
import com.hiberus.checkout.order.dto.LogisticResponse;
import com.hiberus.checkout.order.dto.NewOrderDataResponse;
import com.hiberus.checkout.order.dto.Order;
import com.hiberus.checkout.order.dto.Products;
import com.hiberus.checkout.order.service.BillService;
import com.hiberus.checkout.order.service.CheckoutService;
import com.hiberus.checkout.order.service.LogisticService;

import reactor.core.publisher.Mono;

@Service
@Primary
public class CheckoutServiceWebFluxImpl extends HiberusCheckoutServiceBaseImpl implements CheckoutService {

	private String billUrl;
	private String logisticUrl;

	@Override
	public NewOrderDataResponse createOrder(Order products) {
		WebClient billClient = WebClient.create(this.billUrl + BillService.BILL_RESOURCE);
		Products request = this.getConversionService().convert(products, Products.class);
		Mono<BillResponse> bill = billClient.put().bodyValue(request).retrieve().bodyToMono(BillResponse.class);
		WebClient logisticClient = WebClient.create(this.logisticUrl + LogisticService.LOGISTIC_RESOURCE);
		Mono<LogisticResponse> logistic = logisticClient.post().bodyValue(products).retrieve()
				.bodyToMono(LogisticResponse.class);
		Mono<NewOrderDataResponse> response = bill
				.map(res -> NewOrderDataResponse.builder().total(res.getData().getTotal())).zipWith(logistic)
				.map(build -> build.getT1().order(build.getT2().getData())).map(fin -> fin.build());
		return response.block();
	}

	public String getBillUrl() {
		return billUrl;
	}

	@Autowired
	@Value("${com.hiberus.checkout.bill.endpoint}")
	public void setBillUrl(String billUrl) {
		this.billUrl = billUrl;
	}

	public String getLogisticUrl() {
		return logisticUrl;
	}

	@Autowired
	@Value("${com.hiberus.checkout.logistic.endpoint}")
	public void setLogisticUrl(String logisticUrl) {
		this.logisticUrl = logisticUrl;
	}

}
