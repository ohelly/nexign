package ru.nexign.core.service.winner;

import java.util.List;

import ru.nexign.core.entity.Winner;

/**
 * Сервис для управления победителями лотерей.
 */
public interface WinnerService {

	/**
	 * Вычисление победителя лотерии.
	 *
	 * @return Winner - данные победителя.
	 */
	Winner calculateWinner();

	/**
	 * Получить всех победителей.
	 *
	 * @return List<Winner> - список победителей.
	 */
	List<Winner> getWinners();
}
