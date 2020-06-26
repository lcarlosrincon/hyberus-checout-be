package com.hiberus.checkout.order.dto;

public enum GeneralErrorEnum {
	
	ERROR_VALIDACION_REQUEST("request.validation.fields.error"),
	ERROR_FORMATO_JSON("request.format.json.error"),
	ERROR_PARAMETRO_NOT_FOUND("request.validation.fields.notFound.error"),
	ERROR_TOKEN_EXPIRATED("request.validation.token.expirated.error"),
	ERROR_INTERNO("internal.server.error");
	
	private String messageKey;
	
	private GeneralErrorEnum(String messageKey) {
		this.messageKey = messageKey;
	}
	
	public String getMessageKey() {
		return messageKey;
	}
	
	public static String getMessageKey(GeneralErrorEnum error) {
		return error.getMessageKey();
	}

}
