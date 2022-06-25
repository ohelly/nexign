package ru.nexign.core.service.winner;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.nexign.core.entity.Participant;
import ru.nexign.core.entity.Winner;
import ru.nexign.core.exception.BusinessException;
import ru.nexign.core.repository.WinnerRepository;
import ru.nexign.core.service.participant.ParticipantService;
import ru.nexign.lottery.service.LotteryService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class WinnerServiceImpl implements WinnerService {

	private final ParticipantService participantService;

	private final LotteryService lotteryService;

	private final WinnerRepository winnerRepository;

	@Transactional
	public Winner calculateWinner() {
		if (participantService.getCountOfParticipant() >= 2) {
			log.info("participants more than or equal 2");
			return calculatingWinner();
		} else {
			log.info("participant less than 2");
			throw new BusinessException("Недостаточно участников для начала лотерии");
		}
	}

	private Winner calculatingWinner() {
		log.info("calculating winner");
		List<Participant> participants = participantService.getAll();
		Long winnerId = lotteryService
				.calculatingWinner(participants.stream().map(Participant::getId).collect(Collectors.toList()));
		log.info("winner id = {}", winnerId);
		Participant participant = participantService.getById(winnerId);
		Integer sum = lotteryService.calculatingWinningAmount();
		log.info("winning amount = {}", sum);
		Winner winner = new Winner();
		winner.setAge(participant.getAge());
		winner.setCity(participant.getCity());
		winner.setName(participant.getName());
		winner.setSum(sum);
		winnerRepository.save(winner);
		participantService.deleteAll();
		log.info("end calculating winner, winner = {}", winner);
		return winner;
	}

	@Transactional(readOnly = true)
	public List<Winner> getWinners() {
		log.info("find all winners");
		return winnerRepository.findAll();
	}
}
