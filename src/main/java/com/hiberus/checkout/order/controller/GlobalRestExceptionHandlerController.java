package com.hiberus.checkout.order.controller;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.hiberus.checkout.order.dto.DefaultErrorResponse;
import com.hiberus.checkout.order.dto.GeneralErrorEnum;
import com.hiberus.checkout.order.utils.Constants;
import com.hiberus.checkout.order.utils.MessageUtil;
import com.hiberus.checkout.order.utils.ValidationErrorUtils;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice(basePackages = Constants.PATH_CONTROLLERS)
@Slf4j
public class GlobalRestExceptionHandlerController {

	@Autowired
	private MessageUtil messageUtil;

	@Autowired
	private ValidationErrorUtils validationErrorUtils;

	@ExceptionHandler(BindException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ResponseBody
	public DefaultErrorResponse handleException(BindException e) {
		log.error("Ocurrió un error de validacion", e);
		DefaultErrorResponse response = createValidationError(e);
		populateHttpDataError(response, HttpStatus.BAD_REQUEST, GeneralErrorEnum.ERROR_VALIDACION_REQUEST);
		response.setStatus(HttpStatus.BAD_REQUEST.value());
		return response;
	}

	private DefaultErrorResponse createValidationError(BindingResult e) {
		return this.validationErrorUtils.getError(e);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ResponseBody
	public DefaultErrorResponse handleException(MethodArgumentNotValidException e) {
		log.error("Ocurrió un error de validacion", e);
		DefaultErrorResponse response = createValidationError(e.getBindingResult());
		populateHttpDataError(response, HttpStatus.BAD_REQUEST, GeneralErrorEnum.ERROR_VALIDACION_REQUEST);
		response.setStatus(HttpStatus.BAD_REQUEST.value());
		return response;
	}

	@ExceptionHandler(HttpMessageNotReadableException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ResponseBody
	public DefaultErrorResponse handleRestTASException(HttpMessageNotReadableException e) {
		log.error("La peticion json no es correcta", e);
		DefaultErrorResponse response = new DefaultErrorResponse();
		populateHttpDataError(response, HttpStatus.BAD_REQUEST, GeneralErrorEnum.ERROR_FORMATO_JSON);
		response.setMessage(e.getMessage());

		return response;
	}

	@ExceptionHandler(NoSuchElementException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ResponseBody
	public DefaultErrorResponse handleExceptionNoSuchElement(NoSuchElementException e) {
		log.error("Elemento no encontrado ", e);
		DefaultErrorResponse response = new DefaultErrorResponse();
		populateHttpDataError(response, HttpStatus.NOT_FOUND, GeneralErrorEnum.ERROR_PARAMETRO_NOT_FOUND);
		response.setMessage(e.getMessage());

		return response;
	}
//	
//	@ExceptionHandler(JwtException.class)
//	@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
//	@ResponseBody
//	public DefaultErrorResponse expiredJwtExceptionHandler(JwtException e) {
//		LOGGER.error("No autorizado ", e);
//		DefaultErrorResponse response = new DefaultErrorResponse();
//		populateHttpDataError(response, HttpStatus.UNAUTHORIZED, GeneralErrorEnum.ERROR_TOKEN_EXPIRATED);
//		response.setMessage(e.getMessage());
//
//		return response;
//	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public DefaultErrorResponse handleException(Exception e) {
		log.error("Ocurrió un error inesperado", e);
		DefaultErrorResponse response = new DefaultErrorResponse();
		populateHttpDataError(response, HttpStatus.INTERNAL_SERVER_ERROR, GeneralErrorEnum.ERROR_INTERNO);
		response.setMessage(e.getMessage());

		return response;
	}

	private void populateHttpDataError(DefaultErrorResponse response, HttpStatus status,
			GeneralErrorEnum errorValidacionRequest) {
		response.setStatus(status.value());
		response.setError(messageUtil.getMessage(errorValidacionRequest.getMessageKey()));

	}

}
