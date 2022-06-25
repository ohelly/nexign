package ru.nexign.core.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

/**
 * ДТО для участника лоттерии.
 */
@Data
public class ParticipantDto {

	@NotBlank(message = "name should be not null")
	private String name;

	@NotNull(message = "age should be not null")
	@Min(value = 18, message = "age should be greater than 18")
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private Integer age;

	@NotBlank(message = "city must be not null")
	private String city;
}
