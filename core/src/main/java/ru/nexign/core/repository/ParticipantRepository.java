package ru.nexign.core.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ru.nexign.core.entity.Participant;

/**
 * Репозиторий для сущности {@link Participant}.
 */
@Repository
public interface ParticipantRepository extends JpaRepository<Participant, Long> {

	@Query("select count(p) from Participant p")
	Integer countParticipant();

	List<Participant> findByOrderById();
}
