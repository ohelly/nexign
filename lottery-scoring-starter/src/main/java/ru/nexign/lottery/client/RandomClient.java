package ru.nexign.lottery.client;

import feign.Param;
import feign.RequestLine;

/**
 * Feign-client для рандомайзера.
 */
public interface RandomClient {

	@RequestLine("GET /integers/?num=1&min={min}&max={max}&col=1&base=10&format=plain&rnd=new")
	Integer getOneNumber(@Param("min") Integer min, @Param("max") Integer max);
}
