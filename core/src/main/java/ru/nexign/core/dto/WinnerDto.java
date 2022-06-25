package ru.nexign.core.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

/**
 * ДТО для победителя лотерии.
 */
@Data
public class WinnerDto extends ParticipantDto {

	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private Integer sum;
}
