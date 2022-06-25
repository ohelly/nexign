package ru.nexign.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ru.nexign.core.entity.Winner;

/**
 * Репозиторий для сущности {@link Winner}
 */
@Repository
public interface WinnerRepository extends JpaRepository<Winner, Long> {
}
