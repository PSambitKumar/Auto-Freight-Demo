package com.infy.auto_freight.exception;

import org.springframework.http.HttpStatus;

import java.io.Serial;

public class InternalServerErrorException extends IBookAfrException {

	public InternalServerErrorException(String reason, String code, String description, HttpStatus httpStatus) {
		super(reason, code, description, httpStatus);
	}

	@Serial
	private static final long serialVersionUID = 1L;
}
