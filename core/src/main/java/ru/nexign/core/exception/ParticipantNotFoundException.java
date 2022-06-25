package ru.nexign.core.exception;

/**
 * Ошибка, когда участник не найден.
 */
public class ParticipantNotFoundException extends RuntimeException {

	public ParticipantNotFoundException(String message) {
		super(message);
	}
}
