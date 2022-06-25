package ru.nexign.core.exception;

/**
 * Бизнесовая ошибка.
 */
public class BusinessException extends RuntimeException {

	public BusinessException(String message) {
		super(message);
	}
}
