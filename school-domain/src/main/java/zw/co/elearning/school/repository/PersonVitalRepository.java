package zw.co.elearning.school.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import zw.co.elearning.school.domain.PersonVital;

/**
 * Spring Data JPA repository for the PersonVital entity.
 */
@SuppressWarnings("unused")
public interface PersonVitalRepository extends JpaRepository<PersonVital, String> {

	List<PersonVital> findByIdIn(List<String> list);

	Page<PersonVital> findByPersonId(String personId, Pageable pageable);

	Page<PersonVital> findByPersonIdAndVitalId(String personId, Long vitalId, Pageable pageable);

	List<PersonVital> findByPersonIdAndDateBetween(String personId, LocalDateTime fro, LocalDateTime to);

	List<PersonVital> findByPersonIdAndDateGreaterThanEqualAndDateLessThanEqualOrderByDateAsc(String personId,
			LocalDateTime fro, LocalDateTime to);

	List<PersonVital> findByPersonIdAndDateGreaterThanEqualOrderByDateAsc(String personId, LocalDateTime fro);

	List<PersonVital> findByPersonIdAndVitalIdAndDateGreaterThanEqualAndDateLessThanEqualOrderByDateAsc(String personId,
			Long vitalId, LocalDateTime fro, LocalDateTime to);

	List<PersonVital> findByPersonIdAndVitalIdAndDateGreaterThanEqualOrderByDateAsc(String personId, Long vitalId,
			LocalDateTime fro);

	Page<PersonVital> getByPersonIdAndDateBetween(String personId, LocalDateTime from, LocalDateTime to,	Pageable pageable);

	PersonVital findByPersonIdAndVitalIdAndDate(String personId, Long vitalId, LocalDateTime date);



}
