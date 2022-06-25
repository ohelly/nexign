package ru.nexign.core.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * Сущность участника лоттерии.
 */
@Entity
@Table(name = "participant")
@Data
public class Participant extends ParticipantCommonData {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
}
