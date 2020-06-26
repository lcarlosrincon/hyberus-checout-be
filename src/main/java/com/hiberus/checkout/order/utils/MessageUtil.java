package com.hiberus.checkout.order.utils;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

@Component
public class MessageUtil {

	@Autowired
	private MessageSource messageSource;

	public String getMessage(String key) {
		return messageSource.getMessage(key, new Object[] {}, LocaleContextHolder.getLocale());
	}

	public String getMessage(String key, Locale local) {
		return messageSource.getMessage(key, new Object[] {}, local);
	}

	public String getMessage(String key, Object[] params) {
		return messageSource.getMessage(key, params, LocaleContextHolder.getLocale());
	}

	public String getMessage(String key, Object[] params, Locale local) {
		return messageSource.getMessage(key, params, local);
	}

}
