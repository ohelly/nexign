package ru.nexign.core.controller;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.nexign.core.dto.WinnerDto;
import ru.nexign.core.entity.Winner;
import ru.nexign.core.service.winner.WinnerService;

import lombok.RequiredArgsConstructor;

/**
 * Контроллер для управления лотереей.
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/lottery")
public class LotteryController {

	private final WinnerService winnerService;

	private final ModelMapper modelMapper;

	/**
	 * Запуск лотерии.
	 *
	 * @return WinnerDto - Победитель лотерии.
	 */
	@GetMapping(value = "/start")
	public WinnerDto startLottery() {
		Winner entity = winnerService.calculateWinner();
		return modelMapper.map(entity, WinnerDto.class);
	}
}
