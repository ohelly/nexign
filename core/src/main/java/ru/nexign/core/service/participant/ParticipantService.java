package ru.nexign.core.service.participant;

import java.util.List;

import ru.nexign.core.dto.ParticipantDto;
import ru.nexign.core.entity.Participant;

/**
 * Сервис для участников лотерии.
 */
public interface ParticipantService {

	/**
	 * Сохранение нового участника.
	 *
	 * @param dto - Данные об участнике.
	 * @return - Данные сохраненного участника.
	 */
	Participant createParticipant(ParticipantDto dto);

	/**
	 * Получить всех участников.
	 *
	 * @return List<Participant> - список всех участников
	 */
	List<Participant> getAll();

	/**
	 * Получить количество участников.
	 *
	 * @return Кол-во участникоов.
	 */
	Integer getCountOfParticipant();

	/**
	 * Получить участника по идентификатору.
	 *
	 * @param id - идентификатор участника.
	 * @return Participant - участник.
	 */
	Participant getById(Long id);

	/**
	 * Удаление всех участников.
	 */
	void deleteAll();
}
