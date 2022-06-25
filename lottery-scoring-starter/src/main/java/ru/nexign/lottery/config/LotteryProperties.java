package ru.nexign.lottery.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

/**
 * Свойства для лоттерии.
 */
@Data
@ConfigurationProperties(prefix = "lottery")
public class LotteryProperties {

	/**
	 * Максимальная сумма выигрыша.
	 */
	private Integer max;

	/**
	 * Минимальная сумма выигрыша.
	 */
	private Integer min;

	/**
	 * УРЛ к рандомайзеру.
	 */
	private String url;
}
