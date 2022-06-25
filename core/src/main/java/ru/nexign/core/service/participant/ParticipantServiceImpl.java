package ru.nexign.core.service.participant;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ru.nexign.core.dto.ParticipantDto;
import ru.nexign.core.entity.Participant;
import ru.nexign.core.exception.ParticipantNotFoundException;
import ru.nexign.core.repository.ParticipantRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class ParticipantServiceImpl implements ParticipantService {

	private final ParticipantRepository repository;

	private final ModelMapper modelMapper;

	@Transactional
	@Override
	public Participant createParticipant(ParticipantDto dto) {
		log.info("create new participant, dto = {}", dto);
		Participant entity = modelMapper.map(dto, Participant.class);
		return repository.save(entity);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Participant> getAll() {
		log.info("find all participant");
		return repository.findByOrderById();
	}

	@Override
	@Transactional(readOnly = true)
	public Integer getCountOfParticipant() {
		log.info("get count of participant");
		return repository.countParticipant();
	}

	@Transactional(readOnly = true)
	public Participant getById(Long id) {
		log.info("get participant by id, id = {}", id);
		return repository.findById(id)
						 .orElseThrow(() -> new ParticipantNotFoundException(String.format("Участник с id = %d не найден", id)));
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void deleteAll() {
		log.info("deleting all participants");
		repository.deleteAll();
	}
}
