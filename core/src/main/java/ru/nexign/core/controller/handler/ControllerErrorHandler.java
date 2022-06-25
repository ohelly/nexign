package ru.nexign.core.controller.handler;

import java.net.BindException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import ru.nexign.core.dto.ErrorMessage;
import ru.nexign.core.exception.BusinessException;
import ru.nexign.core.exception.ParticipantNotFoundException;

/**
 * Обработка ошибок.
 */
@ControllerAdvice
@ResponseBody
public class ControllerErrorHandler {

	@ExceptionHandler(BusinessException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorMessage processBusinessException(BusinessException exception) {
		return ErrorMessage.builder().message(exception.getMessage()).build();
	}

	@ExceptionHandler(ParticipantNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorMessage processParticipantNotFoundException(ParticipantNotFoundException exception) {
		return ErrorMessage.builder().message(exception.getMessage()).build();
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorMessage processBindException(MethodArgumentNotValidException ex) {
		return ErrorMessage.builder().message("Ошибка валидации").errors(ex
				.getBindingResult()
				.getFieldErrors()
				.stream().map(FieldError::getDefaultMessage)
				.collect(Collectors.toList())).build();
	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ErrorMessage processException(Exception exception) {
		return ErrorMessage.builder().message("Внутренняя ошибка сервера. message = " + exception.getMessage()).build();
	}
}
