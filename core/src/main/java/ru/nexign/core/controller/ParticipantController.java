package ru.nexign.core.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.nexign.core.dto.ParticipantDto;
import ru.nexign.core.entity.Participant;
import ru.nexign.core.service.participant.ParticipantService;

import lombok.RequiredArgsConstructor;

/**
 * Контроллер для работы с участниками лоттерии.
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/lottery")
public class ParticipantController {

	private final ParticipantService participantService;

	private final ModelMapper modelMapper;

	/**
	 * Сохранить нового участника лотерии.
	 *
	 * @param dto - данные участника.
	 * @return ParticipantDto - сохраненный участник.
	 */
	@PostMapping(value = "/participant", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ParticipantDto createParticipant(@RequestBody @Valid ParticipantDto dto) {
		Participant entity = participantService.createParticipant(dto);
		return modelMapper.map(entity, ParticipantDto.class);
	}

	/**
	 * Получить всех участников лотерии.
	 *
	 * @return List<ParticipantDto> - данные участников лотерии
	 */
	@GetMapping(value = "/participant", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ParticipantDto> getAllParticipant() {
		List<Participant> entities = participantService.getAll();
		return entities
				.stream()
					   .map(element -> modelMapper.map(element, ParticipantDto.class))
				.collect(Collectors.toList());
	}
}
