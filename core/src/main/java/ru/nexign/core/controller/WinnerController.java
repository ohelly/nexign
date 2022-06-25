package ru.nexign.core.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.nexign.core.dto.WinnerDto;
import ru.nexign.core.entity.Winner;
import ru.nexign.core.service.winner.WinnerService;

import lombok.RequiredArgsConstructor;

/**
 * Контроллер для управления победителями лотерей.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/lottery")
public class WinnerController {

	private final WinnerService winnerService;

	private final ModelMapper modelMapper;

	/**
	 * Получить всех победителей.
	 *
	 * @return List<WinnerDto> - Данные победителей.
	 */
	@GetMapping(value = "/winners", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<WinnerDto> getWinners() {
		List<Winner> winners = winnerService.getWinners();
		return winners.stream()
					  .map(element -> modelMapper.map(element, WinnerDto.class)).collect(Collectors.toList());
	}
}
