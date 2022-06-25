package ru.nexign.core.entity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import lombok.Data;

/**
 * Общие данные для участников и победителей лотерии.
 */
@Data
@MappedSuperclass
public class ParticipantCommonData {

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "age", nullable = false)
	private Integer age;

	@Column(name = "city", nullable = false)
	private String city;
}
