package ru.nexign.core.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Builder;
import lombok.Data;

/**
 * Класс для ответа при ошибке.
 */
@Data
@Builder
public class ErrorMessage {

	private String message;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private List<String> errors;
}
