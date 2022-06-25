package ru.nexign.lottery.service;

import java.util.List;

/**
 * Сервис определения результатов.
 */
public interface LotteryService {

	/**
	 * Получаем сумму выигрыша.
	 *
	 * @return Integer - сумма выигрыша между min и max, где min и max - необходимо задать в application.yml.
	 */
	Integer calculatingWinningAmount();

	/**
	 * Определяем победителя.
	 *
	 * @param ids - идентификаторы участников.
	 * @return Long - идентификатор победителя.
	 */
	Long calculatingWinner(List<Long> ids);
}
