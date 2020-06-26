package com.hiberus.checkout.order.utils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import com.hiberus.checkout.order.dto.DefaultErrorResponse;
import com.hiberus.checkout.order.dto.ErrorDataBasic;

@Component
public class ValidationErrorUtils {

	private MessageUtil messageUtil;

	public DefaultErrorResponse getError(Errors errors) {
		DefaultErrorResponse error = new DefaultErrorResponse();
		error.setMessage("Validation failed. " + errors.getErrorCount() + " error(s)");

		for (ObjectError objectError : errors.getAllErrors()) {
			if (FieldError.class.isAssignableFrom(objectError.getClass())) {
				FieldError fieldError = (FieldError) objectError;
				ErrorDataBasic errorField = new ErrorDataBasic();
				errorField.setField(fieldError.getField());
				errorField.setMessage(fieldError.getDefaultMessage());
				error.addError(errorField);
			} else {
				ErrorDataBasic errorField = new ErrorDataBasic();
				errorField.setMessage(objectError.getDefaultMessage());
				error.addError(errorField);
			}

		}
		return error;
	}

	public DefaultErrorResponse getErrorFromGenericException(Exception errors) {
		DefaultErrorResponse error = new DefaultErrorResponse();

		if (StringUtils.isNotBlank(errors.getMessage())) {
			error.addError(new ErrorDataBasic(null, errors.getMessage()));
		}
		return error;
	}

	public MessageUtil getMessageUtil() {
		return messageUtil;
	}

	@Autowired
	public void setMessageUtil(MessageUtil messageUtil) {
		this.messageUtil = messageUtil;
	}

}
