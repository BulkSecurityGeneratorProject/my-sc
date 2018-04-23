package zw.co.elearning.school.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import zw.co.elearning.school.service.dto.PersonVitalDTO;

/**
 * Service Interface for managing PersonVital.
 */
public interface PersonVitalService {

	/**
	 * Save a personVital.
	 *
	 * @param personVitalDTO
	 *            the entity to save
	 * @return the persisted entity
	 */
	PersonVitalDTO save(PersonVitalDTO personVitalDTO);

	/**
	 * Get all the personVitals.
	 * 
	 * @param pageable
	 *            the pagination information
	 * @return the list of entities
	 */
	Page<PersonVitalDTO> findAll(Pageable pageable);

	/**
	 * Get the "id" personVital.
	 *
	 * @param id
	 *            the id of the entity
	 * @return the entity
	 */
	PersonVitalDTO findOne(String id);

	/**
	 * Delete the "id" personVital.
	 *
	 * @param id
	 *            the id of the entity
	 */
	void delete(String id);

	List<PersonVitalDTO> findByIds(String[] ids);

	

	
	
	Page<PersonVitalDTO> getByPersonIdAndDateBetweenForPartogram(String personId, LocalDateTime from, LocalDateTime to,
			Pageable pageable);


	List<Map<String, Object>> findByPersonIdVitalIdAndDateBetween(String deliveryId, Long personId, Long vitalId,LocalDateTime from,
			 LocalDateTime to);

	PersonVitalDTO findByVitalIdAndPersonIdAndDate(String personId, Long vitalId, LocalDateTime date);

	
}
