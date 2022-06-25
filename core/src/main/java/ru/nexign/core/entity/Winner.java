package ru.nexign.core.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * Сущность победителя лотерии.
 */
@Entity
@Table(name = "winner")
@Data
public class Winner extends ParticipantCommonData {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "sum", nullable = false)
	private Integer sum;
}
