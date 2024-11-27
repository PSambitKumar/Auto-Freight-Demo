package com.infy.auto_freight.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.io.Serial;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class IBookAfrException extends RuntimeException {
	@Serial
	private static final long serialVersionUID = 1L;

	private final String reason;
	private final String code;
	private final String description;
	private final HttpStatus httpStatus;
}
