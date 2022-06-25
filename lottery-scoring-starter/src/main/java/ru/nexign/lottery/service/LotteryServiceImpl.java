package ru.nexign.lottery.service;

import java.util.List;

import ru.nexign.lottery.client.RandomClient;
import ru.nexign.lottery.config.LotteryProperties;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
public class LotteryServiceImpl implements LotteryService {

	private final RandomClient randomClient;

	private final LotteryProperties lotteryProperties;

	@Override
	public Integer calculatingWinningAmount() {
		log.info("start calculating winning amount");
		Integer sum = randomClient.getOneNumber(lotteryProperties.getMin(), lotteryProperties.getMax());
		log.info("end calculating winning amount, amount = {}", sum);
		return sum;
	}

	@Override
	public Long calculatingWinner(List<Long> ids) {
		log.info("start calculating winner, size = {}", ids.size());
		Integer winner = randomClient.getOneNumber(1, ids.size());
		log.info("winner id = {}", ids.get(winner - 1));
		return ids.get(winner - 1);
	}
}
