package com.hiberus.checkout.order.config;

import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBeans {

	private static final int THREADS = 10;

	@Bean
	public RestTemplate restTemplate() {
		RestTemplate template = new RestTemplate();
		PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();
		connectionManager.setMaxTotal(THREADS);
		connectionManager.setDefaultMaxPerRoute(2);
		template.setRequestFactory(new HttpComponentsClientHttpRequestFactory(
				HttpClients.custom().setConnectionManager(connectionManager).build()));
		return template;
	}

}
