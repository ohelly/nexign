package ru.nexign.lottery.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ru.nexign.lottery.client.RandomClient;
import ru.nexign.lottery.service.LotteryService;
import ru.nexign.lottery.service.LotteryServiceImpl;

import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;

/**
 * Конфигурация стартера.
 */
@Configuration
@EnableConfigurationProperties(LotteryProperties.class)
public class AppConfig {


	@Bean
	public RandomClient randomClient(LotteryProperties lotteryProperties) {
		return Feign.builder().client(new OkHttpClient())
					.encoder(new GsonEncoder())
					.decoder(new GsonDecoder())
					.logger(new Slf4jLogger(RandomClient.class))
					.logLevel(Logger.Level.FULL)
					.target(RandomClient.class, lotteryProperties.getUrl());
	}

	@Bean
	@ConditionalOnMissingBean
	public LotteryService lotteryService(RandomClient randomClient, LotteryProperties lotteryProperties) {
		return new LotteryServiceImpl(randomClient, lotteryProperties);
	}
}
